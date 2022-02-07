package com.liferay.headless.apps.internal.resource.v1_0;

import com.liferay.headless.apps.resource.v1_0.AppResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Vitaliy Koshelenko
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/app.properties",
	scope = ServiceScope.PROTOTYPE, service = AppResource.class
)
public class AppResourceImpl extends BaseAppResourceImpl {
}