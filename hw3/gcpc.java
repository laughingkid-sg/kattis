class gcpc {
	public static void main(String[] args) {
        
        final Kattio io = new Kattio(System.in, System.out);
        AVL rankedAbove = new AVL();
        Team[] teams = new Team[io.getInt()];
        final int eventCount = io.getInt(); int teamNo;
        for (int i = 0; i < teams.length; i++)
            teams[i] = new Team();
        Team favoriteTeam = teams[0];
        for (int i = 0; i < eventCount; i++) {
            teamNo = io.getInt() - 1; // zero index
            teams[teamNo].nextEvent(io.getInt()); // Update event
            if (teamNo == 0) /* If first team scores */ {
                for (int j : rankedAbove.toArr()) {
					if (favoriteTeam.compareTo(teams[j]) >= 0) // favoriteTeam overtake previous team
                    rankedAbove.delete(j);
                }
            }
            if (favoriteTeam.compareTo(teams[teamNo]) < 0) // favoriteTeam ranked below round winning team
                rankedAbove.insert(teamNo);
            io.println(rankedAbove.size() + 1); // Rank: K + 1
        }
        io.close();
    }
}

class Team implements Comparable<Team> {
	int score;
	int penalty;

	public Team() {
		this.score = 0;
		this.penalty = 0;
	}

    public void nextEvent(int penalty) {
		this.score++;
		this.penalty += penalty;
	}

	public int compareTo(Team team) {
		if (this.score == team.score) 
			return team.penalty - this.penalty;
		return this.score - team.score;
	}
}