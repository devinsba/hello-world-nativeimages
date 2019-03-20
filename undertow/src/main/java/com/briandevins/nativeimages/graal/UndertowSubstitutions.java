package com.briandevins.nativeimages.graal;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import javax.net.ssl.SSLEngine;

public class UndertowSubstitutions {

    @TargetClass(className = "io.undertow.protocols.alpn.JettyAlpnProvider$Impl")
    static final class OrgXnioXnioOsgiSupport {
        @Substitute
        static SSLEngine setProtocols(final SSLEngine engine, final String[] protocols) {
            return null;
        }
    }

}
