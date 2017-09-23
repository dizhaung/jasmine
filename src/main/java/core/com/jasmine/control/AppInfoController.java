package core.com.jasmine.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

@RestController
public class AppInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AppInfoController.class);
    private Properties buildInfo = null;
    private static String hostname = "unknown";

    static {
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public AppInfoController() {
        try {
            buildInfo = PropertiesLoaderUtils.loadAllProperties("properties/buildinfo.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/appver", method = RequestMethod.GET)
    public HashMap<String, String> appVersion(HttpServletRequest request) {
        HashMap<String, String> appVer = new HashMap<String, String>(10);
        if (buildInfo != null) {
            for (Object key : buildInfo.keySet()) {
                appVer.put(key.toString(), buildInfo.getProperty(key.toString()));
            }
        }

        // set runtime information
        appVer.put("run.host", hostname);
        if (request.getHeader("X-Real-IP") != null) {
            appVer.put("run.remote", request.getHeader("X-Real-IP"));
        } else {
            appVer.put("run.remote", request.getRemoteHost());
        }

        return appVer;
    }
}
