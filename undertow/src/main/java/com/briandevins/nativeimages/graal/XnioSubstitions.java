package com.briandevins.nativeimages.graal;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import org.xnio.Xnio;

public class XnioSubstitions {

    @TargetClass(className = "org.xnio.Xnio$OsgiSupport")
    static final class OrgXnioXnioOsgiSupport {
        @Substitute
        static Xnio doGetOsgiService() {
            return null;
        }
    }

}
