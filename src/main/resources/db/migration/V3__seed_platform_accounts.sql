INSERT INTO management_users (
    organization_id, role_id, username, password_hash, enabled, created_at, updated_at
)
SELECT NULL, roles.id, 'platform-admin',
       '$2y$10$E/9aay/8upXKz00iVsvwx.i9qY/DkCljpmBCfzzpLIDcO.SZnNyb0',
       TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM roles
WHERE roles.name = 'PLATFORM_ADMIN';


INSERT INTO management_users (
    organization_id, role_id, username, password_hash, enabled, created_at, updated_at
)
SELECT NULL, roles.id, 'gateway-service',
       '$2y$10$XqKpKYK3zLNzLV540bZwee68JvjRjY79J6kaTSFD0gruXRD6jXU0',
       TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM roles
WHERE roles.name = 'GATEWAY_SERVICE';