/**
 * 
 */
package nl.rug.tdconfession.domain;

import java.io.Serializable;
import java.util.Date;

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
	@NamedQuery(name = "Confession.findByCountry", query = "SELECT c FROM Confession c WHERE c.country = :country"),
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
	@Column(name = "country")
	private String country;
	@Column(name = "possitive_votes")
	private Integer possitiveVotes;
	@Column(name = "negative_votes")
	private Integer negativeVotes;
	@Basic(optional = false)
	@Column(name = "posted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date posted;

	public Confession() {
	}

	public Confession(Integer id) {
		this.id = id;
	}

	public Confession(Integer id, Date posted) {
		this.id = id;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPossitiveVotes() {
		return possitiveVotes;
	}

	public void setPossitiveVotes(Integer possitiveVotes) {
		this.possitiveVotes = possitiveVotes;
	}

	public Integer getNegativeVotes() {
		return negativeVotes;
	}

	public void setNegativeVotes(Integer negativeVotes) {
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
