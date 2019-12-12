package br.edu.ifpb.dac.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
  name="java:global/jdbc/DACDataSource",
  className="org.postgresql.Driver",
  url="jdbc:postgresql://localhost:5432/projeto-dac",
  databaseName="projeto-dac",
  user="postgres",
  password="secret")
public class DataSourceDefinitionConfig {
}