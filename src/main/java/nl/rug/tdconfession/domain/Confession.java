/**
 * 
 */
package nl.rug.tdconfession.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Georgios Digkas <digasgeo@yahoo.gr>
 *
 */
@Entity
@Table(name = "confession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Confession.findAll", query = "SELECT c FROM Confession c"),
    @NamedQuery(name = "Confession.findById", query = "SELECT c FROM Confession c WHERE c.id = :id"),
    @NamedQuery(name = "Confession.findByLocale", query = "SELECT c FROM Confession c WHERE c.locale = :locale"),
    @NamedQuery(name = "Confession.findByPossitiveVotes", query = "SELECT c FROM Confession c WHERE c.possitiveVotes = :possitiveVotes"),
    @NamedQuery(name = "Confession.findByNegativeVotes", query = "SELECT c FROM Confession c WHERE c.negativeVotes = :negativeVotes"),
    @NamedQuery(name = "Confession.findByPosted", query = "SELECT c FROM Confession c WHERE c.posted = :posted")})
public class Confession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "confession_text")
    private String confessionText;
    @Column(name = "locale")
    private String locale;
    @Basic(optional = false)
    @Column(name = "possitive_votes")
    private int possitiveVotes;
    @Basic(optional = false)
    @Column(name = "negative_votes")
    private int negativeVotes;
    @Basic(optional = false)
    @Column(name = "posted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posted;

    public Confession() {
    	// Empty constructor for setter-based creating Objects
    }

    public Confession(Integer id) {
        this.id = id;
    }

    public Confession(Integer id, int possitiveVotes, int negativeVotes, Date posted) {
        this.id = id;
        this.possitiveVotes = possitiveVotes;
        this.negativeVotes = negativeVotes;
        this.posted = posted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfessionText() {
        return confessionText;
    }

    public void setConfessionText(String confessionText) {
        this.confessionText = confessionText;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getPossitiveVotes() {
        return possitiveVotes;
    }

    public void setPossitiveVotes(int possitiveVotes) {
        this.possitiveVotes = possitiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Confession)) {
            return false;
        }
        Confession other = (Confession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "nl.rug.tdconfession.domain.Confession[ id=" + id + " ]";
	}

}
