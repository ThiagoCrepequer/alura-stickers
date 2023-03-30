import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private Properties props = new Properties();
    private FileInputStream fis;

    public ReadProperties() {
        try {
            fis = new FileInputStream("config.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProps(String props) {
        return this.props.getProperty(props);
    }
}
