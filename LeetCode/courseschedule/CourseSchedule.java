package com.leetcode.courseschedule;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/*
207. Course Schedule
https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = getMap(prerequisites);
        Set<Integer> courseToTake = new HashSet<>();
        for (int course = 0; course < numCourses && map.size() > 0; course++) {
            courseToTake.clear();
            courseToTake.add(course);
            boolean loopExist = loopExist(course, map, courseToTake);
            if (loopExist) {
                return false;
            }
        }
        return true;
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

    private boolean loopExist(int course, Map<Integer, List<Integer>> prerequisites, Set<Integer> courseToTake) {
        if (!prerequisites.containsKey(course)) {
            return false;
        }
        List<Integer> dependentCourses = prerequisites.get(course);
        boolean loopExist = false;
        for (int dependentCourse : dependentCourses) {
            if (courseToTake.contains(dependentCourse)) {
                return true;
            }
            courseToTake.add(dependentCourse);
            loopExist = loopExist(dependentCourse, prerequisites, courseToTake);
            prerequisites.remove(course);
            courseToTake.remove(dependentCourse);
            if (loopExist) return true;
        }
        return loopExist;
    }

    private CourseSchedule obj;

    @Before
    public void setUp() {
        obj = new CourseSchedule();
    }

    @After
    public void cleanUp() {
        obj = null;
    }

    @Test
    public void testNoDependancyShouldReturnTrue() {
        int courseNo = 2;
        int[][] prerequisites = {{0, 1}};
        assertEquals(true, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void testDependancyShouldReturnFalse() {
        int courseNo = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        assertEquals(false, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void testDependancyShouldReturnFalseForCircular() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 0}};
        assertEquals(false, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void testDependancyShouldReturnFalseForIndividualAndAfterCircular() {
        int courseNo = 3;
        int[][] prerequisites = {{0, 5}, {1, 4}, {2, 6}, {3, 7}, {4, 5}, {5, 4}};
        assertEquals(false, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void testDependancyForTwoCourseShouldReturnFalse() {
        int courseNo = 3;
        int[][] prerequisites = {{0,1},{0,2},{2,0}};
        assertEquals(false, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void emptyShouldReturnTrue() {
        int courseNo = 0;
        int[][] prerequisites = {};
        assertEquals(true, obj.canFinish(courseNo, prerequisites));
    }

    @Test
    public void testNoDependancyForTwoCourseShouldReturnTrue() {
        int courseNo = 3;
        int[][] prerequisites = {{0,1},{0,2},{1,2}};
        assertEquals(true, obj.canFinish(courseNo, prerequisites));
    }

}