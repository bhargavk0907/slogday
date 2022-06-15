package slog.day.entity;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@SuppressWarnings("all")
@Entity
@Table(name = "member_info", schema = "slogday")
public class MemberInfo {
    private Integer memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date dob;
    private Timestamp createdTs;
    private Timestamp updatedTs;
    private String createdBy;
    private String updatedBy;

    @Id
    @Column(name = "member_id", nullable = false)
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 40)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email_address", nullable = false, length = 100)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "dob", nullable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "created_ts", nullable = false)
    public Timestamp getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Timestamp createdTs) {
        this.createdTs = createdTs;
    }

    @Basic
    @Column(name = "updated_ts", nullable = false)
    public Timestamp getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Timestamp updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Basic
    @Column(name = "created_by", nullable = false, length = 40)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "updated_by", nullable = false, length = 40)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfo that = (MemberInfo) o;
        return memberId == that.memberId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(createdTs, that.createdTs) &&
                Objects.equals(updatedTs, that.updatedTs) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, firstName, lastName, emailAddress, dob, createdTs, updatedTs, createdBy, updatedBy);
    }
}

