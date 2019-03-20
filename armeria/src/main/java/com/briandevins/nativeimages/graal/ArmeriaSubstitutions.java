package com.briandevins.nativeimages.graal;

import com.linecorp.armeria.internal.PathAndQuery;
import com.linecorp.armeria.internal.shaded.caffeine.cache.Cache;
import com.linecorp.armeria.server.PathMappingContext;
import com.linecorp.armeria.server.ServiceConfig;
import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

public class ArmeriaSubstitutions {
    @TargetClass(className = "com.linecorp.armeria.internal.shaded.caffeine.cache.UnsafeRefArrayAccess")
    static final class Target_com_linecorp_armeria_internal_shaded_caffeine_cache_UnsafeRefArrayAccess {
        @Alias
        @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexShift, declClass = Object[].class)
        public static int REF_ELEMENT_SHIFT;
    }

    @TargetClass(className = "com.linecorp.armeria.internal.PathAndQuery")
    static final class Target_com_linecorp_armeria_internal_PathAndQuery {
        @Alias
        @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.Reset, isFinal = true)
        private static Cache<String, PathAndQuery> CACHE;
    }

    @TargetClass(className = "com.linecorp.armeria.server.RouteCache")
    static final class Target_com_linecorp_armeria_server_RouteCache {
        @Alias
        @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.Reset, isFinal = true)
        private static Cache<PathMappingContext, ServiceConfig> CACHE;
    }

    @TargetClass(className = "com.linecorp.armeria.common.Flags")
    static final class Target_com_linecorp_armeria_common_Flags {
        @Substitute
        private static boolean isEpollAvailable() {
            return false;
        }
    }
}
