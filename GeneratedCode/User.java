/***********************************************************************
 * Module:  User.java
 * Author:  rezgu
 * Purpose: Defines the Class User
 ***********************************************************************/

import java.util.*;

/** @pdOid 5aae3bd0-7392-4611-a80d-6ba3b9b051ec */
public class User {
   /** @pdOid be2aa4bc-7091-4e93-a3c6-b3464d74a89f */
   private int integerId;
   /** @pdOid 0a53f7b8-5e74-4907-ae53-97eb8386394f */
   private String firstName;
   /** @pdOid b44ee2f8-76ad-4925-a0e2-9f88ede31471 */
   private String lastName;
   /** @pdOid 83127276-f8cc-42c2-97d9-ddfc23a810ef */
   private String email;
   /** @pdOid 96302870-90ae-4c63-a3b6-dcd1fbb90b78 */
   private String password;
   /** @pdOid c29bebd6-f075-4472-b1ef-a75f90e1ab20 */
   private Role role;
   
   /** @pdRoleInfo migr=no name=Profil assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Profil> profil;
   
   /** @pdOid d13526a5-2e3c-4db3-afb4-efe5ac55fc38 */
   public boolean gererProfilPersonel() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 5620f825-f588-4df7-804e-42aae7bdae7c */
   public boolean changerMotdepasse() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 2b11cbb7-c33d-49d5-979f-b60d2d8f3cc7 */
   public boolean s_authentifier() {
      // TODO: implement
      return false;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Profil> getProfil() {
      if (profil == null)
         profil = new java.util.HashSet<Profil>();
      return profil;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProfil() {
      if (profil == null)
         profil = new java.util.HashSet<Profil>();
      return profil.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProfil */
   public void setProfil(java.util.Collection<Profil> newProfil) {
      removeAllProfil();
      for (java.util.Iterator iter = newProfil.iterator(); iter.hasNext();)
         addProfil((Profil)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProfil */
   public void addProfil(Profil newProfil) {
      if (newProfil == null)
         return;
      if (this.profil == null)
         this.profil = new java.util.HashSet<Profil>();
      if (!this.profil.contains(newProfil))
         this.profil.add(newProfil);
   }
   
   /** @pdGenerated default remove
     * @param oldProfil */
   public void removeProfil(Profil oldProfil) {
      if (oldProfil == null)
         return;
      if (this.profil != null)
         if (this.profil.contains(oldProfil))
            this.profil.remove(oldProfil);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProfil() {
      if (profil != null)
         profil.clear();
   }

}