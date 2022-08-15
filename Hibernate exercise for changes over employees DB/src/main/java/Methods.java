
import model.Angajat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;



public class Methods implements MethodsInterface {


    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tran = null;


    public boolean insert(Angajat angajat) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tran = session.beginTransaction();
            String strInsert = "insert into angajati(Prenume, Varsta, Adresa, Salariu) values ('" + angajat.getPrenume() + "','" + angajat.getVarsta() + "','" + angajat.getAdresa() + "'," + angajat.getSalariu() + ")";
            Query q1 = session.createNativeQuery(strInsert);
            int result = q1.executeUpdate();
            session.save(angajat);
            tran.commit();
            return result == 1;
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return false;

    }

    public boolean modify(Angajat oldData, Angajat newData) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tran = session.beginTransaction();
            String strUpdate = "update angajati set Prenume=:prenume, Varsta=:varsta, Adresa=:adresa, Salariu=:salariu  WHERE id_angajati=:id";
            Query q2 = session.createNativeQuery(strUpdate);
            q2.setParameter("prenume", newData.getPrenume());
            q2.setParameter("varsta", newData.getVarsta());
            q2.setParameter("adresa", newData.getAdresa());
            q2.setParameter("salariu", newData.getSalariu());
            q2.setParameter("id", oldData.getId());
            int result = q2.executeUpdate();
            session.save(newData);
            tran.commit();
            return result == 1;
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return false;

    }


    public boolean delete(Angajat angajat) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tran = session.beginTransaction();
            String strDel = "delete from angajati WHERE id_angajati=:id";
            Query q3 = session.createNativeQuery(strDel);
            q3.setParameter("id", angajat.getId());
            int result = q3.executeUpdate();
            tran.commit();
            return result == 1;
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public List<Angajat> displayAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Angajat", Angajat.class).list();

        }
    }


        public List<Angajat> displaySelective(String criteriu){

            if (criteriu.startsWith("prenume")) {
                String[] arrayData = criteriu.split("=");

                if (arrayData.length != 2) return null;
                String prenume = arrayData[1].trim();
                try (Session session = HibernateUtils.getSessionFactory().openSession()) {
                    tran = session.beginTransaction();
                    String hql = "SELECT A FROM Angajat A WHERE A.prenume = :prenumeParam";
                    Query query = session.createQuery(hql);
                    query.setParameter("prenumeParam", prenume);
                    List<Angajat> results = query.getResultList();
                    tran.commit();
                    return results;
                } catch (Exception e) {
                    if (tran != null) {
                        tran.rollback();
                    }
                    e.printStackTrace();
                }
            } else if (criteriu.startsWith("varsta")) {
                String[] arrayData = criteriu.split("=");

                if (arrayData.length != 2) return null;
                String varsta = arrayData[1].trim();
                Session session = HibernateUtils.getSessionFactory().openSession();
                try { System.out.println("Varsta " + varsta);
                    tran = session.beginTransaction();
                    String hql = "SELECT A FROM Angajat A WHERE A.varsta = :varstaParam";
                    Query query = session.createQuery(hql);
                    query.setParameter("varstaParam", Integer.parseInt(varsta.trim()));
                    List<Angajat> results = query.getResultList();
                    System.out.println("size list " + results.size());
                    tran.commit();
                    return results;
                } catch (Exception e) {
                    if (tran != null) {
                        tran.rollback();
                    }
                    e.printStackTrace();
                }
            } else if (criteriu.startsWith("adresa")) {
                String[] arrayData = criteriu.split("=");

                if (arrayData.length != 2) return null;
                String adresa = arrayData[1].trim();
                try (Session session = HibernateUtils.getSessionFactory().openSession()) {
                    tran = session.beginTransaction();
                    String hql = "SELECT A FROM Angajat A WHERE A.adresa = :adresaParam";
                    Query query = session.createQuery(hql);
                    query.setParameter("adresaParam", adresa);
                    List<Angajat> results = query.getResultList();
                    tran.commit();
                    return results;
                } catch (Exception e) {
                    if (tran != null) {
                        tran.rollback();
                    }
                    e.printStackTrace();
                }

            } else if (criteriu.startsWith("salariu")) {
                String[] arrayData = criteriu.split("=");

                if (arrayData.length != 2) return null;
                String salariu = arrayData[1].trim();
                Session session = HibernateUtils.getSessionFactory().openSession();
                try  {
                    tran = session.beginTransaction();
                    String hql = "SELECT A FROM Angajat A WHERE A.salariu = :salariuParam";
                    Query query = session.createQuery(hql);
                    query.setParameter("salariuParam", Integer.parseInt(salariu.trim()));
                    List<Angajat> results = query.getResultList();
                    tran.commit();
                    return results;
                } catch (Exception e) {
                    if (tran != null) {
                        tran.rollback();
                    }
                    e.printStackTrace();
                }}
            return null;
        }

                public void close() throws SQLException {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}


