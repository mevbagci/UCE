package org.texttechnologylab.uce.common.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.texttechnologylab.models.authentication.DocumentPermission;

/**
 * Immutable access snapshot for the current principal.
 */
public final class DocumentAccessContext {

    private final String principal;

    private final Map<Long, DocumentPermission.DOCUMENT_PERMISSION_LEVEL> cachedPermissions =
            Collections.synchronizedMap(new java.util.HashMap<>());

    public DocumentAccessContext(String principal) {
        this.principal = principal;
    }

    public String principal() {
        return principal;
    }

    public void cachePermission(long documentId, DocumentPermission.DOCUMENT_PERMISSION_LEVEL level) {
        cachedPermissions.put(documentId, level);
    }

    public void cachePermissions(Collection<Long> documentIds,
                                 DocumentPermission.DOCUMENT_PERMISSION_LEVEL level) {
        for (long id : documentIds) {
            cachedPermissions.put(id, level);
        }
    }

    public DocumentPermission.DOCUMENT_PERMISSION_LEVEL cachedPermission(long documentId) {
        return cachedPermissions.get(documentId);
    }

    @Override
    public String toString() {
        return "DocumentAccessContext{principal='%s'}".formatted(principal);
    }
}
