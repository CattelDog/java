import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        long time = scan.nextLong();
        String[] grid = new String[rows];
        
        scan.nextLine();
        // Initial state of grid
        for (int i = 0; i < rows; i++) {
            grid[i] = scan.nextLine();
        }
        
        
        if (time%2 == 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("O");
                }
                System.out.println("");
            }
            
        } else if (time == 1) {
            for (int i = 0; i < rows; i++) {
                System.out.println(grid[i]);
            }
            
        } else {
            time = time % 4 + 3;
        
        
        
 
        
        // Alternate between planting bombs in the rest of the cells and exploding the original bombs
            if (rows > 1 && cols > 1) {
                while (time > 0) {
               
                    // Next second
                    for (int i = 0; i < rows; i++) {
                        grid[i] = grid[i].replace("O", "2");
                        grid[i] = grid[i].replace(".", "O");
                    }

                    /*
                    // plant bombs in remaining spots
                    for (int i = 0; i < rows; i++) {
                        grid[i] = grid[i].replace(".", "O");
                    }
                    */
                    
                    time -= 1;
                    if (time == 0) {
                        for (int i = 0; i < rows; i++) {
                            grid[i] = grid[i].replace("2", "O");
                            System.out.println(grid[i]);
                        }
                    } else {
                        // Third second, all original bombs detonate
                        for (int i = 0; i < rows; i++) {
                            grid[i] = grid[i].replace("2", "3");
                            grid[i] = grid[i].replace("O", "2");            
                        }


                        // spread the damage
                        int c = cols - 1;
                        int r = rows - 1;
                        if (grid[0].charAt(0) == '3') {
                            if (grid[0].charAt(1) != '3') {
                                grid[0] = ".." + grid[0].substring(2);
                            } else {
                                grid[0] = "." + grid[0].substring(1);
                            }

                            if (grid[1].charAt(0) != '3') {
                                grid[1] = "." + grid[1].substring(1);
                            }
                        }

                        if (grid[0].charAt(c) == '3') {
                            if (grid[0].charAt(c - 1) != '3') {
                                grid[0] = grid[0].substring(0, cols - 2) + "..";
                            } else {
                                grid[0] = grid[0].substring(0, cols - 1) + ".";
                            }

                            if (grid[1].charAt(c) != '3') {
                                grid[1] = grid[1].substring(0, c) + ".";
                            }
                        }

                        if (grid[r].charAt(0) == '3') {
                            if (grid[r].charAt(1) != '3') {
                                grid[r] = ".." + grid[r].substring(2);
                            } else {
                                grid[r] = "." + grid[r].substring(1);
                            }

                            if (grid[r-1].charAt(0) != '3') {
                                grid[r-1] = "." + grid[r-1].substring(1);
                            }
                        }

                        if (grid[r].charAt(c) == '3') {
                            if (grid[r].charAt(c-1) != '3') {
                                grid[r] = grid[r].substring(0, c - 1) + "..";
                            } else {
                                grid[r] = grid[r].substring(0, c) + ".";
                            }

                            if (grid[r-1].charAt(c) != '3') {
                                grid[r-1] = grid[r-1].substring(0, c) + ".";
                            }
                        }

                        for (int i = 1; i < cols - 1; i++) {
                            if (grid[0].charAt(i) == '3') {
                                if (grid[1].charAt(i) != '3') {
                                    grid[0] = grid[0].substring(0,i) + "." + grid[0].substring(i+1);
                                    grid[1] = grid[1].substring(0,i) + "." + grid[1].substring(i+1);
                                } else {
                                    grid[0] = grid[0].substring(0,i) + "." + grid[0].substring(i+1);
                                }

                                if (grid[0].charAt(i+1) != '3') {
                                    grid[0] = grid[0].substring(0,i+1) + "." + grid[0].substring(i+2);
                                }

                                grid[0] = grid[0].substring(0, i-1) + "." + grid[0].substring(i);
                            }

                            if (grid[r].charAt(i) == '3') {
                                if (grid[r-1].charAt(i) != '3') {
                                    grid[r] = grid[r].substring(0,i) + "." + grid[r].substring(i+1);
                                    grid[r-1] = grid[r-1].substring(0,i) + "." + grid[r-1].substring(i+1);
                                } else {
                                    grid[r] = grid[r].substring(0,i) + "." + grid[r].substring(i+1);
                                }

                                if (grid[r].charAt(i+1) != '3') {
                                    grid[r] = grid[r].substring(0,i+1) + "." + grid[r].substring(i+2);
                                }

                                grid[r] = grid[r].substring(0, i-1) + "." + grid[r].substring(i);

                            }
                        }

                        for (int i = 1; i < rows - 1; i++) {
                             if (grid[i].charAt(0) == '3') {
                                if (grid[i].charAt(1) != '3') {
                                    grid[i] = ".." + grid[i].substring(2);
                                } else {
                                    grid[i] = "." + grid[i].substring(1);
                                }

                                if (grid[i+1].charAt(0) != '3') {
                                    grid[i+1] = "." + grid[i+1].substring(1);
                                }

                                grid[i-1] = "." + grid[i-1].substring(1);
                            }
                            
                            if (grid[i].charAt(c) == '3') {
                                if (grid[i].charAt(c-1) != '3') {
                                    grid[i] = grid[i].substring(0,c-1) + "..";
                                } else {
                                    grid[i] = grid[i].substring(0,c) + ".";
                                }

                                if (grid[i+1].charAt(c) != '3') {
                                    grid[i+1] = grid[i+1].substring(0,c) + ".";
                                }

                                grid[i-1] = grid[i-1].substring(0,c) + ".";

                            }   
                        }

                        for (int i = 1; i < r; i++) {
                            for (int j = 1; j < c; j++) {
                                if (grid[i].charAt(j) == '3') {
                                    if (grid[i].charAt(j+1) != '3') {
                                        grid[i] = grid[i].substring(0, j) + ".." + grid[i].substring(j+2);
                                    } 

                                    if (grid[i+1].charAt(j) != '3') {
                                        grid[i] = grid[i].substring(0, j) + "." + grid[i].substring(j+1);
                                        grid[i+1] = grid[i+1].substring(0, j) + "." + grid[i+1].substring(j+1);
                                    } 

                                    grid[i] = grid[i].substring(0,j-1) + ".." + grid[i].substring(j+1);
                                    grid[i-1] = grid[i-1].substring(0,j) + "." + grid[i-1].substring(j+1);
                                }
                            }
                        }

                        time -= 1;
                        if (time == 0) {
                            for (int i = 0; i < rows; i++) {
                                grid[i] = grid[i].replace("2", "O");
                                System.out.println(grid[i]);
                            }
                        }
                    
                    }
                
                }
            } else if (rows == 1) {
                char[] gridArr = grid[0].toCharArray();
                
                
                
                
                while (time > 0) {
                    // Next second
                    for (int i = 0; i < cols; i++) {
                        if (gridArr[i] == 'O') {
                            gridArr[i] = '2';
                        } else if (gridArr[i] == '.') {
                            gridArr[i] = 'O';
                        }
                       
                    }
                    
                    time -= 1;
                    if (time == 0) {
                        for (int i = 0; i < cols; i++) {
                            if (gridArr[i] == '2') {
                                gridArr[i] = 'O';
                            }
                            System.out.print(gridArr[i]);
                        }
                        System.out.println("");
                    } else {
                        // Third second, all original bombs detonate
                        for (int i = 0; i < cols; i++) {
                            if (gridArr[i] == '2') {
                                gridArr[i] = '3';
                            } else if (gridArr[i] == 'O') {
                                gridArr[i] = '2';
                            }
                                     
                        }
                        
                        // spread the damage
                        if (gridArr[0] == '3') {
                            if (gridArr[1] != '3') {
                                gridArr[1] = '.';
                            }
                            gridArr[0] = '.';
                        }
                        
                        for (int i = 1; i < cols - 1; i++) {
                            if (gridArr[i] == '3') {
                                if (gridArr[i+1] != '3') {
                                    gridArr[i+1] = '.';
                                }
                                gridArr[i-1] = '.';
                                gridArr[i] = '.';
                            }
                        }
                        
                        if (gridArr[cols-1] == '3') {
                            gridArr[cols-2] = '.';
                            gridArr[cols-1] = '.';
                        }
                        
                        time -= 1;
                        if (time == 0) {
                            for (int i = 0; i < cols; i++) {
                                if (gridArr[i] == '2') {
                                    gridArr[i] = 'O';
                                }
                                System.out.print(gridArr[i]);
                            }
                            System.out.println("");
                        }
                        
                    }

                    
                }
            } else if (cols == 1) {
                while (time > 0) {
                    // Next second
                    for (int i = 0; i < rows; i++) {
                        if (grid[i].charAt(0) == 'O') {
                            grid[i] = grid[i].replace("O", "2");
                        } else if (grid[i].charAt(0) == '.') {
                            grid[i] = grid[i].replace(".", "O");
                        }
                       
                    }
                    
                    time -= 1;
                    if (time == 0) {
                        for (int i = 0; i < rows; i++) {
                            if (grid[i].charAt(0) == '2') {
                                grid[i] = grid[i].replace("2", "O");
                            }
                            System.out.println(grid[i]);
                        }
                    } else {
                        // Third second, all original bombs detonate
                        for (int i = 0; i < rows; i++) {
                            if (grid[i].charAt(0) == '2') {
                                grid[i] = grid[i].replace("2", "3");
                            } else if (grid[i].charAt(0) == 'O') {
                                grid[i] = grid[i].replace("O", "2");
                            }
                                     
                        }
                        
                        // spread the damage
                        if (grid[0].charAt(0) == '3') {
                            if (grid[1].charAt(0) != '3') {
                                grid[1] = grid[1].replace(grid[1].substring(0), ".");
                            }
                            grid[0] = grid[0].replace(grid[0].substring(0), ".");
                        }
                        
                        for (int i = 1; i < rows - 1; i++) {
                            if (grid[i].charAt(0) == '3') {
                                if (grid[i+1].charAt(0) != '3') {
                                    grid[i+1] = grid[i+1].replace(grid[i+1].substring(0), ".");
                                }
                                grid[i-1] = grid[i-1].replace(grid[i-1].substring(0), ".");
                                grid[i] = grid[i].replace(grid[i].substring(0), ".");
                            }
                        }
                        
                        if (grid[rows-1].charAt(0) == '3') {
                            grid[rows-2] = grid[rows-2].replace(grid[rows-2].substring(0), ".");
                            grid[rows-1] = grid[rows-1].replace(grid[rows-1].substring(0), ".");
                        }
                        
                        time -= 1;
                        if (time == 0) {
                            for (int i = 0; i < rows; i++) {
                                if (grid[i].charAt(0) == '2') {
                                    grid[i] = grid[i].replace("2", "O");
                                }
                                System.out.println(grid[i]);
                            }
                            
                        }
                        
                    }

                    
                }
            }
        }
        
        
    }
}