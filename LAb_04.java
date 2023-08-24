import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Match {
    private String location;
    private String team1;
    private String team2;
    private String timing;

    public Match(String location, String team1, String team2, String timing) {
        this.location = location;
        this.team1 = team1;
        this.team2 = team2;
        this.timing = timing;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTiming() {
        return timing;
    }
}

class FlightTable {
    private List<Match> matches;

    public FlightTable() {
        matches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> listMatchesByTeam(String teamName) {
        List<Match> teamMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTeam1().equals(teamName) || match.getTeam2().equals(teamName)) {
                teamMatches.add(match);
            }
        }
        return teamMatches;
    }

    public List<Match> listMatchesByLocation(String location) {
        List<Match> locationMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getLocation().equals(location)) {
                locationMatches.add(match);
            }
        }
        return locationMatches;
    }

    public List<Match> listMatchesByTiming(String timing) {
        List<Match> timingMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTiming().equals(timing)) {
                timingMatches.add(match);
            }
        }
        return timingMatches;
    }
}

public class Main {
    public static void main(String[] args) {
        FlightTable flightTable = new FlightTable();

        flightTable.addMatch(new Match("Mumbai", "India", "Sri Lanka", "DAY"));
        flightTable.addMatch(new Match("Delhi", "England", "Australia", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Chennai", "India", "South Africa", "DAY"));
        flightTable.addMatch(new Match("Indore", "England", "Sri Lanka", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Mohali", "Australia", "South Africa", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Delhi", "India", "Australia", "DAY"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Search options:");
            System.out.println("1. List of all the matches of a Team");
            System.out.println("2. List of Matches on a Location");
            System.out.println("3. List of Matches based on timing");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the team name: ");
                String teamName = scanner.nextLine();
                List<Match> teamMatches = flightTable.listMatchesByTeam(teamName);
                for (Match match : teamMatches) {
                    System.out.println("Location: " + match.getLocation() +
                                       ", Teams: " + match.getTeam1() + " vs " + match.getTeam2() +
                                       ", Timing: " + match.getTiming());
                }
            } else if (choice == 2) {
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the location: ");
                String location = scanner.nextLine();
                List<Match> locationMatches = flightTable.listMatchesByLocation(location);
                for (Match match : locationMatches) {
                    System.out.println("Teams: " + match.getTeam1() + " vs " + match.getTeam2() +
                                       ", Timing: " + match.getTiming());
                }
            } else if (choice == 3) {
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the timing: ");
                String timing = scanner.nextLine();
                List<Match> timingMatches = flightTable.listMatchesByTiming(timing);
                for (Match match : timingMatches) {
                    System.out.println("Location: " + match.getLocation() +
                                       ", Teams: " + match.getTeam1() + " vs " + match.getTeam2());
                }
            } else if (choice == 4) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
