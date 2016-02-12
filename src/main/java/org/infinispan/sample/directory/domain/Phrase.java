package org.infinispan.sample.directory.domain;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.Id;
import java.io.Serializable;

@Indexed
public class Phrase implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   private Integer id;

   @Field(index = Index.YES, store = Store.YES)
   private String text;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

}