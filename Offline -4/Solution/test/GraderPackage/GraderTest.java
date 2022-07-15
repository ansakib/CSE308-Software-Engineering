package GraderPackage;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    static private Grader grader;
    static private TestCaseGenerator t;

    @BeforeAll
    static void setUp() {
        grader = new Grader();
        t = new TestCaseGenerator();
    }

    public static Stream<String> threeGrATestCases() {
        return Stream.of(
                t.threeGradeA(), t.upThreeGradeA(), t.downThreeGradeA()
        );
    }
    public static Stream<String> threeGrBTestCases() {
        return Stream.of(
                t.threeGradeB(), t.upThreeGradeB(), t.downThreeGradeB()
        );
    }
    public static Stream<String> threeGrCTestCases() {
        return Stream.of(
                t.threeGradeC(), t.upThreeGradeC(), t.downThreeGradeC()
        );
    }
    public static Stream<String> threeGrFTestCases() {
        return Stream.of(
                t.threeGradeF(), t.upThreeGradeF(), t.downThreeGradeF()
        );
    }


    public static Stream<String> fourGrATestCases() {
        return Stream.of(
                t.fourGradeA(), t.upFourGradeA(), t.downFourGradeA()
        );
    }
    public static Stream<String> fourGrBTestCases() {
        return Stream.of(
                t.fourGradeB(), t.upFourGradeB(), t.downFourGradeB()
        );
    }
    public static Stream<String> fourGrCTestCases() {
        return Stream.of(
                t.fourGradeC(), t.upFourGradeC(), t.downFourGradeC()
        );
    }
    public static Stream<String> fourGrFTestCases() {
        return Stream.of(
                t.fourGradeF(), t.upFourGradeF(), t.downFourGradeF()
        );
    }


    public static Stream<String> invalidCases() {
        return Stream.of(
                t.downInvalidNumbers(), t.upInvalidNumbers()
        );
    }

    public static Stream<String> nonNumberCases() {
        return Stream.of(
                t.non_Number()
        );
    }


    @ParameterizedTest
    @MethodSource("threeGrATestCases")
    void getGradeThreeA(String marks) {
        Assertions.assertTrue("A".equals(grader.getGrade(marks, 3)));
    }

    @ParameterizedTest
    @MethodSource("threeGrBTestCases")
    void getGradeThreeB(String marks) {
        Assertions.assertTrue("B".equals(grader.getGrade(marks, 3)));
    }

    @ParameterizedTest
    @MethodSource("threeGrCTestCases")
    void getGradeThreeC(String marks) {
        Assertions.assertTrue("C".equals(grader.getGrade(marks, 3)));
    }

    @ParameterizedTest
    @MethodSource("threeGrFTestCases")
    void getGradeThreeF(String marks) {
        Assertions.assertTrue("F".equals(grader.getGrade(marks, 3)));
    }


    @ParameterizedTest
    @MethodSource("fourGrATestCases")
    void getGradeFourA(String marks) {
        Assertions.assertTrue("A".equals(grader.getGrade(marks, 4)));
    }

    @ParameterizedTest
    @MethodSource("fourGrBTestCases")
    void getGradeFourB(String marks) {
        Assertions.assertTrue("B".equals(grader.getGrade(marks, 4)));
    }

    @ParameterizedTest
    @MethodSource("fourGrCTestCases")
    void getGradeFourC(String marks) {
        Assertions.assertTrue("C".equals(grader.getGrade(marks, 4)));
    }

    @ParameterizedTest
    @MethodSource("fourGrFTestCases")
    void getGradeFourF(String marks) {
        Assertions.assertTrue("F".equals(grader.getGrade(marks, 4)));
    }


    @ParameterizedTest
    @MethodSource("invalidCases")
    void getGradeInvalid(String marks) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.getGrade(marks,3);
                });

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.getGrade(marks,4);
                });
    }


    @ParameterizedTest
    @MethodSource("nonNumberCases")
    void getGradeNonNumber(String marks) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.getGrade(marks,3);
                });

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.getGrade(marks,4);
                });
    }

    @AfterAll
    static void tearDown() {
        grader = null;
    }
}