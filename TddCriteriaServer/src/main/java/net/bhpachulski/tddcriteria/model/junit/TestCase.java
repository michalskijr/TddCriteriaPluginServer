package net.bhpachulski.tddcriteria.model.junit;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestCase {

    @XmlElement()
    private String className;
    
    @XmlElement()
    private String methodName;
    
    @XmlElement()
    private String packageName;

    @XmlElement()
    private boolean failed;

    @XmlElement()
    private FailDetail failDetail;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public FailDetail getFailDetail() {
        return failDetail;
    }

    public void setFailDetail(FailDetail failDetail) {
        this.failDetail = failDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.methodName);
        hash = 17 * hash + Objects.hashCode(this.packageName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestCase other = (TestCase) obj;
        if (!Objects.equals(this.methodName, other.methodName)) {
            return false;
        }
        return Objects.equals(this.packageName, other.packageName);
    }
}