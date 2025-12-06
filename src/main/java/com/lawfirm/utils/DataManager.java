package com.lawfirm.utils;

import com.lawfirm.models.Client;
import com.lawfirm.models.Goal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManager {
    private static DataManager instance;
    private List<Client> clients;
    private List<Goal> goals;

    private DataManager() {
        clients = new ArrayList<>();
        goals = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    public Client getClientById(String id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public void updateGoal(Goal goal) {
        for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i).getId().equals(goal.getId())) {
                goals.set(i, goal);
                return;
            }
        }
        goals.add(goal);
    }

    public Goal getGoalByNumberAndClient(int goalNumber, String clientId) {
        return goals.stream()
                .filter(g -> g.getGoalNumber() == goalNumber && g.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }

    public List<Goal> getGoalsByClient(String clientId) {
        return goals.stream()
                .filter(g -> g.getClientId().equals(clientId))
                .collect(Collectors.toList());
    }

    public List<Goal> getAllGoals() {
        return new ArrayList<>(goals);
    }
}
