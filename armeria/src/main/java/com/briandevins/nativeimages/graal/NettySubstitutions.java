package com.briandevins.nativeimages.graal;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

public class NettySubstitutions {
    @TargetClass(className = "io.netty.util.internal.PlatformDependent0")
    static final class Target_io_netty_util_internal_PlatformDependent0 {
        @Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.Buffer", name = "address")
        private static long ADDRESS_FIELD_OFFSET;
    }

    @TargetClass(className = "io.netty.util.internal.CleanerJava6")
    static final class Target_io_netty_util_internal_CleanerJava6 {
        @Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.DirectByteBuffer", name = "cleaner")
        private static long CLEANER_FIELD_OFFSET;
    }

    @TargetClass(className = "io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess")
    static final class Target_io_netty_util_internal_shaded_org_jctools_util_UnsafeRefArrayAccess {
        @Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexShift, declClass = Object[].class)
        public static int REF_ELEMENT_SHIFT;
    }

//    @Substitute
//    @TargetClass(className = "io.netty.channel.epoll.Epoll")
//    static final class Target_io_netty_challen_epoll_Epoll {
//        private static final UnsupportedOperationException UNAVAILABILITY_CAUSE = new UnsupportedOperationException("Not supported on Graal native image");
//
//        @Substitute
//        public static void ensureAvailability() {
//            throw UNAVAILABILITY_CAUSE;
//        }
//
//        @Substitute
//        public static boolean isAvailable() {
//            return false;
//        }
//
//        @Substitute
//        public static Throwable unavailabilityCause() {
//            return UNAVAILABILITY_CAUSE;
//        }
//    }
}
