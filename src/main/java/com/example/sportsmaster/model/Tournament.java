package com.example.sportsmaster.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The tournament name should not be empty")
    @Column(name = "tournament_name")
    private String tournament_name;

    @Column(name = "description")
    private String description;

    @Column(name = "tournament_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tournament_date;

    @Column(name = "prize_fund")
    private String prize_fund;

    @ManyToOne
    @JoinColumn(name = "organizer_id", referencedColumnName = "id")
    private Organizer owner;

    @ManyToMany(mappedBy = "tournaments")
    private List<Users> users;

    public Tournament() {}

    public Tournament(String tournament_name, String description, Date tournament_date, String prize_fund) {
        this.tournament_name = tournament_name;
        this.description = description;
        this.tournament_date = tournament_date;
        this.prize_fund = prize_fund;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTournament_date() {
        return tournament_date;
    }

    public void setTournament_date(Date tournament_date) {
        this.tournament_date = tournament_date;
    }

    public String getPrize_fund() {
        return prize_fund;
    }

    public void setPrize_fund(String prize_fund) {
        this.prize_fund = prize_fund;
    }

    public Organizer getOwner() {
        return owner;
    }

    public void setOwner(Organizer owner) {
        this.owner = owner;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
