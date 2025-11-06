package org.texttechnologylab.uce.common.security;

import org.texttechnologylab.models.authentication.DocumentPermission;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Immutable access snapshot for the current principal.
 */
public final class DocumentAccessContext {

    private final String principal;
    private final Map<DocumentPermission.DOCUMENT_PERMISSION_LEVEL, Integer> levelOrdinals =
            new EnumMap<>(DocumentPermission.DOCUMENT_PERMISSION_LEVEL.class);

    private final Map<Long, DocumentPermission.DOCUMENT_PERMISSION_LEVEL> cachedPermissions =
            Collections.synchronizedMap(new java.util.HashMap<>());

    public DocumentAccessContext(String principal) {
        this.principal = principal;
        for (var level : DocumentPermission.DOCUMENT_PERMISSION_LEVEL.values()) {
            levelOrdinals.put(level, level.ordinal());
        }
    }

    public String principal() {
        return principal;
    }

    public int toOrdinal(DocumentPermission.DOCUMENT_PERMISSION_LEVEL level) {
        return levelOrdinals.get(level);
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
