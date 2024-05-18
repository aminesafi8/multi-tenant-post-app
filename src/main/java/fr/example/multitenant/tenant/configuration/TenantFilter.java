package fr.example.multitenant.tenant.configuration;

import fr.example.multitenant.tenant.TenantContextHolder;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static io.micrometer.common.util.StringUtils.isBlank;

@Component
@Slf4j
public class TenantFilter implements Filter {

    private static final String TENANT_HEADER = "X-Tenant-ID";

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final String tenant = computeTenant(httpRequest);

        validate(tenant);
        setTenantContext(tenant);

        try {
            chain.doFilter(request, response);
        } finally {
            clearTenantContext(tenant);
        }
    }

    private void clearTenantContext(final String tenant) {
        log.debug("Clearing tenant context [{}]", tenant);
        TenantContextHolder.clear();
    }

    private void setTenantContext(final String tenant) {
        log.debug("Set the tenant header [{}] to the context", tenant);
        TenantContextHolder.setCurrentTenant(tenant);
    }

    private void validate(final String tenant) throws ServletException {
        if (isBlank(tenant)) {
            throw new ServletException("Tenant header is missing");
        }
    }

    /**
     * Get tenant from Header, Authentication, Subdomain, ...)
     */
    private String computeTenant(final HttpServletRequest httpRequest) {
        return httpRequest.getHeader(TENANT_HEADER);
    }

}
