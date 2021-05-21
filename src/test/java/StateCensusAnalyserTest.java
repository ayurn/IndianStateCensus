import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    public final String CSV_FILE_PATH = "C:\\Users\\AYUR\\IdeaProjects\\IndianStateCensus\\src\\main\\resources\\StateCensusData.csv";
    public final String WRONG_CSV_FILE_PATH = "C:\\Users\\AYUR\\IdeaProjects\\IndianStateCensus\\src\\main\\resources\\StateCensusD.csv";

    private static StateCensusAnalyser censusAnalyser;

    // TC-1.1
    @Test
    public void givenStateCsvFile_CheckNumberOfRecords_ShouldReturnNumber() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numberOfStates = censusAnalyser.loadCensusData(CSV_FILE_PATH);
            Assertions.assertEquals(29, numberOfStates);
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    // TC-1.2
    @Test
    public void givenWrongStateCsvFile_CheckPresentOrNot_ShouldReturnException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("file is not found", exception.getMessage());
        }
    }
}