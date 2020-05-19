package com.base.task.model;

import java.util.UUID;

public class Resume {
  private UUID uuid;
  private String name;
  private String position;

  public Resume(UUID uuid, String name, String position) {
    this.uuid = uuid;
    this.name = name;
    this.position = position;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Resume{" +
        "uuid=" + uuid +
        ", name='" + name + '\'' +
        ", position='" + position + '\'' +
        '}';
  }
}
