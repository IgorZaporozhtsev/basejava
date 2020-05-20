package com.base.task;

import java.util.Arrays;
import java.util.UUID;
import com.base.task.model.Resume;
import com.base.task.storage.ArrayStorage;

public class MainArray {
  static Storage storage = new ArrayStorage();

  public static void main(String[] args) {

    Resume resumeIgor = new Resume(UUID.randomUUID(), "Igor", "Java Developer");
    Resume resumeIgorUpdated = new Resume(UUID.randomUUID(),"IgorUpdate", "C++ Developer");
    Resume resumeSam = new Resume(UUID.randomUUID(),"Sam", "Python Developer");
    Resume resumeTom = new Resume(UUID.randomUUID(),"Tom", "JS Developer");

    System.out.println("--------- SAVE ------ ");
    storage.save(resumeIgor);
    storage.save(resumeSam);
    storage.save(resumeSam);
    storage.save(resumeTom);

    System.out.println("--------- GET ------ ");

    Resume igorByName = storage.getByName("Igor");
    System.out.println("igorByName " + igorByName);
    Resume igorByID = storage.getById(resumeIgor.getUuid());
    System.out.println("igorByID " + igorByID);

    System.out.println(storage.size());

    System.out.println("--------- UPDATE  ------ ");

    storage.update(resumeIgorUpdated);

    System.out.println("--------- DELETE ------ ");

    storage.delete(resumeSam.getUuid());

    System.out.println("--------- GET ALL ------ ");
    Resume[] all = storage.getAll();
    System.out.println(Arrays.asList(all));
  }
}
