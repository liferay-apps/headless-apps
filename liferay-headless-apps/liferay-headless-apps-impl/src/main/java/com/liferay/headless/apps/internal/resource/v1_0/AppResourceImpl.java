package com.liferay.headless.apps.internal.resource.v1_0;

import com.liferay.headless.apps.dto.v1_0.App;
import com.liferay.headless.apps.internal.resource.v1_0.repository.AppRepository;
import com.liferay.headless.apps.resource.v1_0.AppResource;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

/**
 * @author Vitaliy Koshelenko
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/app.properties",
	scope = ServiceScope.PROTOTYPE, service = AppResource.class
)
public class AppResourceImpl extends BaseAppResourceImpl {

	private static final String DATA_FILE = "/data/apps.json";

	private AppRepository appRepository;

	@Activate
	public void init() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			String json = StringUtil.read(classLoader, DATA_FILE, false);
			appRepository = JSONFactoryUtil.looseDeserialize(json, AppRepository.class);
		} catch (Exception e) {
			_log.error("Failed to fetch apps data, cause: " + e.getMessage(), e);
		}
	}

	@Override
	public Page<App> getApps() throws Exception {
		List<App> apps = appRepository.getApps();
		return Page.of(apps);
	}

	private static final Log _log = LogFactoryUtil.getLog(AppResourceImpl.class);
}