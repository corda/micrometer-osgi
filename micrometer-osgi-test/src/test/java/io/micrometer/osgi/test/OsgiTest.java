package io.micrometer.osgi.test;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({ServiceExtension.class, BundleContextExtension.class})
public class OsgiTest {
    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    @Test
    public void testCoreResolves() {
        Bundle bundle = context.getBundle();
        assertThat(bundle).isNotNull();

        CompositeMeterRegistry registry = Metrics.globalRegistry;
        assertThat(registry).isNotNull();
    }
}
