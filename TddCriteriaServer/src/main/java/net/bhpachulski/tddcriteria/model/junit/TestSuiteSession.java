package net.bhpachulski.tddcriteria.model.junit;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestSuiteSession {

    @XmlElement()
    private String launched;

    @XmlElement()
    private String finished;

    @XmlElement()
    private String testRunName;

    @JsonProperty("testCases")
    private List<TestCase> testCases = new ArrayList<>();

    public String getLaunched() {
        return launched;
    }

    public void setLaunched(String launched) {
        this.launched = launched;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getTestRunName() {
        return testRunName;
    }

    public void setTestRunName(String testRunName) {
        this.testRunName = testRunName;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }
}