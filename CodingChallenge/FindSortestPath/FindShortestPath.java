package com.freelance.jin.main;

import com.freelance.jin.helper.Map;
import com.freelance.jin.helper.MapCell;

import java.io.IOException;

public class FindShortestPath {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws IOException {

        if (args.length < 1)
            throw new IllegalArgumentException("Provide the name of the file with the input map");

        String mapFileName = args[0];
        Map cityMap;
        try {
            cityMap = new Map(mapFileName);
        } catch (IOException e) {
            System.out.println("Map file does not found... Please use correct file path");
            throw new IOException();
        }

        // empty priority queue
        DLPriorityQueue<MapCell> priorityQueue = new DLPriorityQueue<>();

        // get starting point
        MapCell start = cityMap.getUWOstore();

        // add to priority queue
        priorityQueue.enqueue(start, 0);

        // mark as enqueued
        start.markEnqueued();

        // customer cell
        MapCell customerCell = null;

        // run while loop while queue is not empty and customer cell is not found
        while (!priorityQueue.isEmpty() && customerCell == null) {

            // remove cell from the queue
            MapCell currentSmallestCell = priorityQueue.getSmallest();

            // mark as dequeued
            currentSmallestCell.markDequeued();

            // found the destination cell
            // current cell is same as destination cell then break loop
            if (currentSmallestCell.isCustomer()) {
                customerCell = currentSmallestCell;
                break;
            }

            // check that does cell is tower or neighbor cell is tower or not
            if (interference(currentSmallestCell)) {
                continue;
            }

            // consider each of the neighbour cell, that is not null and no-flying type
            for (int i = 0; i < 6; i++) {

                if (currentSmallestCell.getNeighbour(i) != null && !currentSmallestCell.getNeighbour(i).isNoFlying() &&
                        !currentSmallestCell.getNeighbour(i).isMarkedDequeued()) {
                    int distance = 1 + currentSmallestCell.getDistanceToStart();
                    MapCell neighbourCell = currentSmallestCell.getNeighbour(i);
                    if (distance < neighbourCell.getDistanceToStart()) {
                        neighbourCell.setDistanceToStart(distance);
                        neighbourCell.setPredecessor(currentSmallestCell);
                    }

                    // set priority
                    double priority = neighbourCell.getDistanceToStart() + neighbourCell.euclideanDistToDest(cityMap);

                    // marked as enqueued and priority is less than priority of neighbour
                    // cell then change the priority of neighbour
                    if (neighbourCell.isMarkedEnqueued() && priority < priorityQueue.getPriority(neighbourCell)) {
                        priorityQueue.changePriority(neighbourCell, priority);
                    }

                    // neighbour is not marked as enqueued then add to priority queue
                    // with the priority
                    if (!neighbourCell.isMarkedEnqueued()) {
                        priorityQueue.enqueue(neighbourCell, neighbourCell.getDistanceToStart() + neighbourCell.euclideanDistToDest(cityMap));
                        neighbourCell.markEnqueued();
                    }
                }
            }
        }

        int count = 0;
        while (customerCell != null && customerCell.getPredecessor() != null) {
            customerCell = customerCell.getPredecessor();
            count++;
        }

        if (count == 0) {
            System.out.println("Path does not exist");
        } else {
            System.out.println("Path exist");
            System.out.println(String.format("Total %d number of cell in path from the initial cell to the destination cell.", ++count));
        }
    }

    //check that does cell is tower or neighbor cell is tower or not
    private static boolean interference(MapCell cell) {
        for (int i = 0; i < 6; i++) {
            if (cell.getNeighbour(i) != null && (cell.isTower() || cell.getNeighbour(i).isTower()))
                return true;
        }
        return false;
    }
}
