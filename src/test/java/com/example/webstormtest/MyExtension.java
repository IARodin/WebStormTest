package com.example.webstormtest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) AllureAttachmentManager.screenshot();
    }
}
