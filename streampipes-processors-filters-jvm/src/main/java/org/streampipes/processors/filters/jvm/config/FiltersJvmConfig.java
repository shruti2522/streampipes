/*
 * Copyright 2017 FZI Forschungszentrum Informatik
 *
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

package org.streampipes.processors.filters.jvm.config;


import org.streampipes.config.SpConfig;
import org.streampipes.container.model.PeConfig;

public enum FiltersJvmConfig implements PeConfig {
	INSTANCE;

	private SpConfig config;

	public final static String serverUrl;
	public final static String iconBaseUrl;

	private final static String service_id = "pe/org.streampipes.processors.filters.jvm";
	private final static String service_name = "Processors Filters JVM";
    private final static String service_container_name = "processors-filters-jvm";

	FiltersJvmConfig() {
		config = SpConfig.getSpConfig(service_id);
		config.register(ConfigKeys.HOST, service_container_name, "Hostname for the pe esper");
		config.register(ConfigKeys.PORT, 8090, "Port for the pe esper");

		config.register(ConfigKeys.ICON_HOST, "backend", "Hostname for the icon host");
		config.register(ConfigKeys.ICON_PORT, 80, "Port for the icons in nginx");
		config.register(ConfigKeys.NGINX_HOST, "localhost", "External hostname of StreamPipes Nginx");
		config.register(ConfigKeys.NGINX_PORT, 80, "External port of StreamPipes Nginx");
		config.register(ConfigKeys.KAFKA_HOST, "kafka", "Host for kafka of the pe sinks project");
		config.register(ConfigKeys.KAFKA_PORT, 9092, "Port for kafka of the pe sinks project");
		config.register(ConfigKeys.ZOOKEEPER_HOST, "zookeeper", "Host for zookeeper of the pe sinks project");
		config.register(ConfigKeys.ZOOKEEPER_PORT, 2181, "Port for zookeeper of the pe sinks project");
		config.register(ConfigKeys.COUCHDB_HOST, "couchdb", "Host for couchdb of the pe sinks project");
		config.register(ConfigKeys.COUCHDB_PORT, 5984, "Port for couchdb of the pe sinks project");
		config.register(ConfigKeys.JMS_HOST, "tcp://activemq", "Hostname for pe actions service for active mq");
		config.register(ConfigKeys.JMS_PORT, 61616, "Port for pe actions service for active mq");

		config.register(ConfigKeys.SERVICE_NAME_KEY, service_name, "The name of the service");

	}
	
	static {
		serverUrl = FiltersJvmConfig.INSTANCE.getHost() + ":" + FiltersJvmConfig.INSTANCE.getPort();
		iconBaseUrl = "http://" + FiltersJvmConfig.INSTANCE.getIconHost() + ":" + FiltersJvmConfig.INSTANCE.getIconPort() +"/assets/img/pe_icons";
	}

	public static final String getIconUrl(String pictureName) {
		return iconBaseUrl +"/" +pictureName +".png";
	}

	@Override
	public String getHost() {
		return config.getString(ConfigKeys.HOST);
	}

	@Override
	public int getPort() {
		return config.getInteger(ConfigKeys.PORT);
	}

	public String getIconHost() {
		return config.getString(ConfigKeys.ICON_HOST);
	}

	public int getIconPort() {
		return config.getInteger(ConfigKeys.ICON_PORT);
	}

	public String getKafkaHost() {
		return config.getString(ConfigKeys.KAFKA_HOST);
	}

	public int getKafkaPort() {
		return config.getInteger(ConfigKeys.KAFKA_PORT);
	}

	public String getKafkaUrl() {
		return getKafkaHost() + ":" + getKafkaPort();
	}

	public String getZookeeperHost() {
		return config.getString(ConfigKeys.ZOOKEEPER_HOST);
	}

	public int getZookeeperPort() {
		return config.getInteger(ConfigKeys.ZOOKEEPER_PORT);
	}

	public String getCouchDbHost() {
		return config.getString(ConfigKeys.COUCHDB_HOST);
	}

	public int getCouchDbPort() {
		return config.getInteger(ConfigKeys.COUCHDB_PORT);
	}

	public String getJmsHost() {
		return config.getString(ConfigKeys.JMS_HOST);
	}

	public int getJmsPort() {
		return config.getInteger(ConfigKeys.JMS_PORT);
	}

	public String getJmsUrl() {
		return getJmsHost() + ":" + getJmsPort();
	}

	public String getNginxHost() {
		return config.getString(ConfigKeys.NGINX_HOST);
	}

	public Integer getNginxPort() {
	    
		return config.getInteger(ConfigKeys.NGINX_PORT);
	}

	@Override
	public String getId() {
		return service_id;
	}

	@Override
	public String getName() {
		return config.getString(ConfigKeys.SERVICE_NAME_KEY);
	}




}
