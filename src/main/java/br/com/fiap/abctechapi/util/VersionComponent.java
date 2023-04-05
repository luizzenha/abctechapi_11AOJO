package br.com.fiap.abctechapi.util;

import br.com.fiap.abctechapi.service.AssistanceService;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class VersionComponent {

    private final Properties properties;

    public VersionComponent() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);
    }

    public String getVersion(){
        return properties.get("build_name") + " - " + properties.get("build_version");
    }
}

