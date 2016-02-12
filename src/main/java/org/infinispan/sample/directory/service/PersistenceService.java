package org.infinispan.sample.directory.service;

import org.infinispan.sample.directory.domain.Phrase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersistenceService {

   private Map<Integer, Phrase> phrases = new HashMap<Integer, Phrase>();

   private int count = 0;

   public void addPhrase(Phrase phrase) {
      int next = count++;
      phrase.setId(next);
      phrases.put(next, phrase);
   }

   public Collection<Phrase> getAll() {
      return phrases.values();
   }

   public Collection<Phrase> search(final String query) {
      return phrases.values().stream().filter(w -> w.getText().contains(query)).collect(Collectors.toList());
   }

   public Phrase get(int id) {
      return phrases.get(id);
   }

   public void deletePhrase(int id) {
      phrases.remove(id);
   }

   public void update(int id, Phrase phrase) {
      phrases.put(id, phrase);
   }
}
