/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.plugin.jdbc;

import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.ConnectorSplit;
import com.facebook.presto.spi.HostAddress;
import com.facebook.presto.spi.TupleDomain;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcSplit
        implements ConnectorSplit
{
    private final String connectorId;
    private final String catalogName;
    private final String schemaName;
    private final String tableName;
    private final String connectionUrl;
    private final Map<String, String> connectionProperties;
    private final TupleDomain<ColumnHandle> tupleDomain;
    private final String splitPart;
    private final List<HostAddress> addresses;
    private final boolean remotelyAccessible;
    private final String baseTableName;
    private final String splitField;
    private final String beginIndex;
    private final String endIndex;
    private final long timeStamp;
    private final int scanNodes;
    private final boolean isCalcStepEnable;
    private final String dbHost;

    @JsonCreator
    public JdbcSplit(
            @JsonProperty("connectorId") String connectorId,
            @JsonProperty("catalogName") @Nullable String catalogName,
            @JsonProperty("schemaName") @Nullable String schemaName,
            @JsonProperty("tableName") String tableName,
            @JsonProperty("connectionUrl") String connectionUrl,
            @JsonProperty("connectionProperties") Map<String, String> connectionProperties,
            @JsonProperty("tupleDomain") TupleDomain<ColumnHandle> tupleDomain,
            @JsonProperty("splitPart") String splitPart,
            @JsonProperty("addresses") List<HostAddress> addresses,
            @JsonProperty("remotelyAccessible") boolean remotelyAccessible,
            @JsonProperty("baseTableName") String baseTableName,
            @JsonProperty("splitField") String splitField,
            @JsonProperty("beginIndex") String beginIndex,
            @JsonProperty("endIndex") String endIndex,
            @JsonProperty("timeStamp") long timeStamp,
            @JsonProperty("scanNodes") int scanNodes,
            @JsonProperty("isCalcStepEnable") boolean isCalcStepEnable,
            @JsonProperty("dbHost") String dbHost)
    {
        this.connectorId = checkNotNull(connectorId, "connector id is null");
        this.catalogName = catalogName;
        this.schemaName = schemaName;
        this.tableName = checkNotNull(tableName, "table name is null");
        this.connectionUrl = checkNotNull(connectionUrl, "connectionUrl is null");
        this.connectionProperties = ImmutableMap.copyOf(checkNotNull(connectionProperties, "connectionProperties is null"));
        this.tupleDomain = checkNotNull(tupleDomain, "tupleDomain is null");
        this.splitPart = splitPart;
        this.remotelyAccessible = remotelyAccessible;
        this.addresses = checkNotNull(addresses, "host addresses is null");
        this.baseTableName = baseTableName;
        this.splitField = splitField;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.timeStamp = timeStamp;
        this.scanNodes = scanNodes;
        this.isCalcStepEnable = isCalcStepEnable;
        this.dbHost = dbHost;
    }

    @JsonProperty
    public String getConnectorId()
    {
        return connectorId;
    }

    @JsonProperty
    @Nullable
    public String getCatalogName()
    {
        return catalogName;
    }

    @JsonProperty
    @Nullable
    public String getSchemaName()
    {
        return schemaName;
    }

    @JsonProperty
    public String getTableName()
    {
        return tableName;
    }

    @JsonProperty
    public String getConnectionUrl()
    {
        return connectionUrl;
    }

    @JsonProperty
    public Map<String, String> getConnectionProperties()
    {
        return connectionProperties;
    }

    @JsonProperty
    public TupleDomain<ColumnHandle> getTupleDomain()
    {
        return tupleDomain;
    }

    @JsonProperty
    @Override
    public boolean isRemotelyAccessible()
    {
        return remotelyAccessible;
    }

    @JsonProperty
    @Override
    public List<HostAddress> getAddresses()
    {
        return addresses;
    }

    @Override
    public Object getInfo()
    {
        return this;
    }

    @JsonProperty
    public String getSplitPart()
    {
        return splitPart;
    }

    @JsonProperty
    public String getBaseTableName()
    {
        return baseTableName;
    }

    @JsonProperty
    public String getSplitField()
    {
        return splitField;
    }

    @JsonProperty
    public String getBeginIndex()
    {
        return beginIndex;
    }

    @JsonProperty
    public String getEndIndex()
    {
        return endIndex;
    }

    @JsonProperty
    public long getTimeStamp()
    {
        return timeStamp;
    }

    @JsonProperty
    public int getScanNodes()
    {
        return scanNodes;
    }

    @JsonProperty
    public boolean isCalcStepEnable()
    {
        return isCalcStepEnable;
    }

    @JsonProperty
    public String getDbHost()
    {
        return dbHost;
    }
}
