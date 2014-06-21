package model;

import junit.framework.TestCase;
import model.MARK_II.VisionCell;

import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 9, 2014
 */
public class OldRetinaTest extends TestCase {
    private OldRetina oldRetina;

    public void setUp() {
        this.oldRetina = new OldRetina(5, 15);
    }

    public void test_seeBMPImage() throws IOException {
        /**
         * Array2DTest.bmp =
         * 000000000000000
         * 000100000000000
         * 000000000000000
         * 000000000000000
         * 000000000000000
         */
        this.oldRetina.seeBMPImage("Array2DTest.bmp");

        VisionCell[][] visionCells = this.oldRetina.getVisionCells();
        int numberOfRows = visionCells.length;
        int numberOfColumns = visionCells[0].length;
        assertEquals(5, numberOfRows);
        assertEquals(15, numberOfColumns);
        assertTrue(visionCells[1][3].getActiveState());
        assertFalse(visionCells[0][3].getActiveState());

        this.oldRetina.seeBMPImage("Array2DTest2.bmp");
        VisionCell[][] visionCells2 = this.oldRetina.getVisionCells();
        /**
         * Array2DTest2.bmp =
         * 000100000000000 NOTE: visionCells2[0][3] = 1 where before it = 0
         * 000000000000000
         * 000000000000000
         * 000000000000000
         * 000000000000000
         */
        int numberOfRows2 = visionCells2.length;
        int numberOfColumns2 = visionCells2[0].length;
        assertEquals(5, numberOfRows2);
        assertEquals(15, numberOfColumns2);
        assertFalse(visionCells2[1][3].getActiveState());
        assertTrue(visionCells2[0][3].getActiveState());
    }
}