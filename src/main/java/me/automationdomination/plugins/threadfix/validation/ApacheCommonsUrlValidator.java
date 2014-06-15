package me.automationdomination.plugins.threadfix.validation;

import org.apache.commons.validator.routines.UrlValidator;
import me.automationdomination.plugins.threadfix.ThreadFixPublisher;

/**
 * public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
 throws IOException, ServletException {

 HttpServletRequest req = (HttpServletRequest)request;

 String requestUrl = req.getRequestURL().toString();
 String queryString = req.getQueryString();
 if (queryString != null) {
 requestUrl += "?" + queryString;
 }

 if (urlValidator.isValid(requestUrl) && isValidQuery(queryString)) {
 chain.doFilter(request, response);
 } else {
 HttpServletResponse res = (HttpServletResponse)response;
 res.sendError(HttpServletResponse.SC_BAD_REQUEST);
 return;
 }
 */

public class ApacheCommonsUrlValidator implements ConfigurationValueValidator {

    String[] schemes = {"http","https"};
	private final UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);


	@Override
	public boolean isValid(final String value) {
		if (value == null || value.length() == 0)
			return false;
        /*
		if (!urlValidator.isValid(value))
            (value == null || value.length() == 0)
			return false;
			String url = ThreadFixPublisher.DescriptorImpl.getCurrentDescriptorByNameUrl();
         */
        // TODO how do you access "url" from ThreadFixPublisher
        if (urlValidator.isValid(ThreadFixPublisher.DescriptorImpl.getCurrentDescriptorByNameUrl())) {
            System.out.println(ThreadFixPublisher.DescriptorImpl.getCurrentDescriptorByNameUrl() + " is valid");
        }
        else {
            System.out.println(ThreadFixPublisher.DescriptorImpl.getCurrentDescriptorByNameUrl() + " is invalid");
        }

		return true;
	}

}
