package com.exasol.adapter;

import java.util.*;
import java.util.stream.Collectors;

public class AdapterProperties extends AbstractAdapterProperties {
    static final String TABLE_FILTER_PROPERTY = "TABLE_FILTER";
    private static final String CATALOG_NAME_PROPERTY = "CATALOG_NAME";
    private static final String SCHEMA_NAME_PROPERTY = "SCHEMA_NAME";
    private static final String CONNECTION_NAME_PROPERTY = "CONNECTION_NAME";
    private static final String CONNECTION_STRING_PROPERTY = "CONNECTION_STRING";
    private static final String USERNAME_PROPERTY = "USERNAME";
    private static final String PASSWORD_PROPERTY = "PASSWORD";
    private static final String DEBUG_ADDRESS_PROPERTY = "DEBUG_ADDRESS";
    private static final String LOG_LEVEL_PROPERTY = "LOG_LEVEL";

    /**
     * Create a new instance of {@link AdapterProperties}
     *
     * @param properties adapter properties
     */
    public AdapterProperties(final Map<String, String> properties) {
        super(properties);
    }

    /**
     * Get the catalog name
     *
     * @return catalog name
     */
    public String getCatalogName() {
        return get(CATALOG_NAME_PROPERTY);
    }

    /**
     * Get the schema name
     *
     * @return schema name
     */
    public String getSchemaName() {
        return get(SCHEMA_NAME_PROPERTY);
    }

    /**
     * Get the connection name
     *
     * @return connection name
     */
    public String getConnectionName() {
        return get(CONNECTION_NAME_PROPERTY);
    }

    /**
     * Get the connection string
     *
     * @return connection string
     */
    public String getConnectionString() {
        return get(CONNECTION_STRING_PROPERTY);
    }

    /**
     * Get the user name
     *
     * @return user name
     */
    public String getUsername() {
        return get(USERNAME_PROPERTY);
    }

    /**
     * Get the password
     *
     * @return password
     */
    public String getPassword() {
        return get(PASSWORD_PROPERTY);
    }

    /**
     * Get the debug address
     *
     * @return debug address
     */
    public String getDebugAddress() {
        return get(DEBUG_ADDRESS_PROPERTY);
    }

    /**
     * Get the log level
     *
     * @return log level
     */
    public String getLogLevel() {
        return get(LOG_LEVEL_PROPERTY);
    }

    /**
     * Get the list of tables for which the metadata will be read from the remote source
     *
     * @return list of tables serving as positive filter criteria
     */
    public List<String> getFilteredTables() {
        if (containsKey(TABLE_FILTER_PROPERTY)) {
            return Arrays.stream(get(TABLE_FILTER_PROPERTY).split(",")) //
                    .map(String::trim) //
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Get empty map
     *
     * @return empty map
     */
    public static AbstractAdapterProperties emptyProperties() {
        return new AdapterProperties(Collections.emptyMap());
    }
}