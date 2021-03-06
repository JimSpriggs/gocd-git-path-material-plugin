package com.thoughtworks.go.scm.plugin.model.requestHandlers;

import com.thoughtworks.go.scm.plugin.util.JsonUtils;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;
import java.util.Map;

public class SCMConfigurationRequestHandler implements RequestHandler {

    @Override
    public GoPluginApiResponse handle(GoPluginApiRequest apiRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("url", createField("URL", null, true, true, false, "0"));
        response.put("username", createField("Username", null, true, false, false, "1"));
        response.put("password", createField("Password", null, true, false, true, "2"));
        response.put("path", createField("Path", null, true, true, false, "3"));
        response.put("branch", createField("Branch", "master", true, false, false, "4"));
        return JsonUtils.renderSuccessApiResponse(response);
    }

    private Map<String, Object> createField(String displayName, String defaultValue, boolean isPartOfIdentity, boolean isRequired, boolean isSecure, String displayOrder) {
        Map<String, Object> fieldProperties = new HashMap<>();
        fieldProperties.put("display-name", displayName);
        fieldProperties.put("default-value", defaultValue);
        fieldProperties.put("part-of-identity", isPartOfIdentity);
        fieldProperties.put("required", isRequired);
        fieldProperties.put("secure", isSecure);
        fieldProperties.put("display-order", displayOrder);
        return fieldProperties;
    }
}
