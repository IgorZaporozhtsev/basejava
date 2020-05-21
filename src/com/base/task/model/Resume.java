package com.base.task.model;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
  private String uuid;
  private String name;
  private String position;

  public Resume(String uuid, String name, String position) {
    this.uuid = uuid;
    this.name = name;
    this.position = position;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resume resume = (Resume) o;
    return Objects.equals(uuid, resume.uuid) &&
        Objects.equals(name, resume.name) &&
        Objects.equals(position, resume.position);
  }

  @Override
  public int hashCode() {

    return Objects.hash(uuid, name, position);
  }

  @Override
  public int compareTo(Resume resume  ) {
    return uuid.compareTo(resume.uuid);
  }
}
