package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Actual2_MST_PrimTest {
    @Test
    void test1() {
        int numCities = 4;
        int[][] roadsAvailable = {
                {0,1},
                {2,3}
        };
        int[][] costNewRoadsConstruct = {
                {0,2,4},
                {0,3,3},
                {1,2,2},
                {1,3,1}
        };

        assertEquals(1, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void cantBuild() {
        int numCities = 6;
        int[][] roadsAvailable = {
                {0,1},
                {2,3}
        };
        int[][] costNewRoadsConstruct = {
                {4,5,1},
                {3,4,2}
        };

        assertEquals(-1, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void test_4citiesNoMissing() {
        int numCities = 4;
        int[][] roadsAvailable = {};
        int[][] costNewRoadsConstruct = {
                {1,3,1},
                {3,2,2},
                {2,1,3},
                {0,1,4},
                {0,2,5},
                {3,0,6}
        };

        assertEquals(7, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void test_4citiesMissingNotNeeded() {
        int numCities = 4;
        int[][] roadsAvailable = {};
        int[][] costNewRoadsConstruct = {
                {1,3,1},
                {3,2,2},
                {0,1,4},
        };

        assertEquals(7, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void test_4cities1Missing_4() {
        int numCities = 4;
        int[][] roadsAvailable = {};
        int[][] costNewRoadsConstruct = {
                {1,3,1},
                {3,2,2},
                {2,1,3},
                {0,2,5},
                {3,0,6}
        };

        assertEquals(8, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void test_4cities1Missing_2() {
        int numCities = 4;
        int[][] roadsAvailable = {};
        int[][] costNewRoadsConstruct = {
                {1,3,1},
                {2,1,3},
                {0,1,4},
                {0,2,5},
                {3,0,6}
        };

        assertEquals(8, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }

    @Test
    void test_4cities1Missing_1() {
        int numCities = 4;
        int[][] roadsAvailable = {};
        int[][] costNewRoadsConstruct = {
                {3,2,2},
                {2,1,3},
                {0,1,4},
                {0,2,5},
                {3,0,6}
        };

        assertEquals(9, new YK_Actual2_MST_Prim().getMinimumCostToConstruct(numCities,roadsAvailable,costNewRoadsConstruct));
    }


}