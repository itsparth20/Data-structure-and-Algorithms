package com.leetcode.courseschedule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertArrayEquals;

/*
210. Course Schedule II
https://leetcode.com/problems/course-schedule-ii/description/
 */

public class CourseSchedule2 {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = getMap(prerequisites);
        Set<Integer> courseToTake = new HashSet<>();
        List<Integer> coursesInSequenceOrder = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            courseToTake.clear();
            if (coursesInSequenceOrder.contains(course)) {
                continue;
            }
            courseToTake.add(course);
            boolean loopExist = loopExist(course, map, courseToTake, coursesInSequenceOrder);
            if (loopExist) {
                return new int[]{};
            }
            coursesInSequenceOrder.add(course);
        }

        return coursesInSequenceOrder.stream().mapToInt(i->i).toArray();
    }

    private Map<Integer, List<Integer>> getMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            map.putIfAbsent(prerequisites[i][0], new ArrayList<Integer>());
            List<Integer> lst = map.get(prerequisites[i][0]);
            lst.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], lst);
        }
        return map;
    }

    private boolean loopExist(int course,
                              Map<Integer, List<Integer>> prerequisites,
                              Set<Integer> courseToTake,
                              List<Integer> coursesInSequenceOrder) {
        if (!prerequisites.containsKey(course)) {
            return false;
        }
        List<Integer> dependentCourses = prerequisites.get(course);
        boolean loopExist = false;
        for (int dependentCourse : dependentCourses) {
            if (!courseToTake.add(dependentCourse)) {
                return true;
            }
            loopExist = loopExist(dependentCourse, prerequisites, courseToTake, coursesInSequenceOrder);

            if (loopExist) {
                return true;
            } else {
                courseToTake.remove(dependentCourse);
                if (!coursesInSequenceOrder.contains(dependentCourse))
                    coursesInSequenceOrder.add(dependentCourse);
            }
        }
        return loopExist;
    }

    private CourseSchedule2 obj;

    @Before
    public void setUp() {
        obj = new CourseSchedule2();
    }

    @After
    public void cleanUp() {
        obj = null;
    }

    @Test
    public void testNoDependancyShouldReturnTrue() {
        int courseNo = 2;
        int[][] prerequisites = {{0, 1}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{0,1},outputArray);
    }

    @Test
    public void testDependancyShouldReturnFalse() {
        int courseNo = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{},outputArray);
    }

    @Test
    public void testDependancyShouldReturnFalseForCircular() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 0}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{},outputArray);
    }

    @Test
    public void testDependancyShouldReturnFalseForIndividualAndAfterCircular() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 5}, {1, 4}, {2, 6}, {3, 7}, {4, 5}, {5, 4}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{},outputArray);
    }

    @Test
    public void testDependancyForTwoCourseShouldReturnFalse() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 1}, {0, 2}, {2, 0}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{},outputArray);
    }

    @Test
    public void emptyShouldReturnTrue() {
        int courseNo = 0;
        int[][] prerequisites = {};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        assertArrayEquals(new int[]{},outputArray);
    }

    @Test
    public void testNoDependancyForTwoCourseShouldReturnTrue() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{0,1,2},outputArray);
    }

    @Test
    public void testMultipleSubject() {
        int courseNo = 4;
        int[][] prerequisites = {{3,0}, {0,1}};
        int[] outputArray = obj.canFinish(courseNo, prerequisites);
        Arrays.sort(outputArray);
        assertArrayEquals(new int[]{0,1,2,3},outputArray);
    }

}
