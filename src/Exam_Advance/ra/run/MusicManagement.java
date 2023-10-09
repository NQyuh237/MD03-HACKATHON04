package Exam_Advance.ra.run;

import java.util.*;
import Exam_Advance.ra.model.*;
public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Singer> singers = new ArrayList<>();
        List<Song> songs = new ArrayList<>();

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    singerManagement(singers, songs, scanner);
                    break;
                case 2:
                    songManagement(singers, songs, scanner);
                    break;
                case 3:
                    searchManagement(singers, songs, scanner);
                    break;
                case 4:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void singerManagement(List<Singer> singers, List<Song> songs, Scanner scanner) {
        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập thông tin ca sĩ mới");
            System.out.println("2. Hiển thị danh sách ca sĩ");
            System.out.println("3. Thay đổi thông tin ca sĩ");
            System.out.println("4. Xóa ca sĩ");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Singer newSinger = new Singer();
                    newSinger.inputData();
                    singers.add(newSinger);
                    System.out.println("Thêm ca sĩ thành công.");
                    break;
                case 2:
                    System.out.println("Danh sách ca sĩ:");
                    for (Singer s : singers) {
                        s.displayData();
                        System.out.println("-------------------------");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã số ca sĩ (id) cần thay đổi thông tin: ");
                    int singerId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Singer s : singers) {
                        if (s.getSingerId() == singerId) {
                            s.inputData();
                            System.out.println("Cập nhật thông tin ca sĩ thành công.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy ca sĩ với mã số " + singerId);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã số ca sĩ (id) cần xóa: ");
                    int singerIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    boolean hasSongs = false;
                    for (Song song : songs) {
                        if (song.getSinger().getSingerId() == singerIdToDelete) {
                            hasSongs = true;
                            break;
                        }
                    }

                    if (hasSongs) {
                        System.out.println("Không thể xóa ca sĩ này vì có bài hát liên quan.");
                    } else {
                        for (Singer s : singers) {
                            if (s.getSingerId() == singerIdToDelete) {
                                singers.remove(s);
                                System.out.println("Xóa ca sĩ thành công.");
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void songManagement(List<Singer> singers, List<Song> songs, Scanner scanner) {
        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập thông tin bài hát mới");
            System.out.println("2. Hiển thị danh sách bài hát");
            System.out.println("3. Thay đổi thông tin bài hát");
            System.out.println("4. Xóa bài hát");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Song newSong = new Song();
                    newSong.inputData(singers);
                    songs.add(newSong);
                    System.out.println("Thêm bài hát thành công.");
                    break;
                case 2:
                    System.out.println("Danh sách bài hát:");
                    for (Song song : songs) {
                        song.displayData();
                        System.out.println("-------------------------");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã số bài hát (id) cần thay đổi thông tin: ");
                    String songId = scanner.nextLine();

                    boolean found = false;
                    for (Song song : songs) {
                        if (song.getSongId().equals(songId)) {
                            song.inputData(singers);
                            System.out.println("Cập nhật thông tin bài hát thành công.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy bài hát với mã số " + songId);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã số bài hát (id) cần xóa: ");
                    String songIdToDelete = scanner.nextLine();

                    for (Iterator<Song> iterator = songs.iterator(); iterator.hasNext(); ) {
                        Song song = iterator.next();
                        if (song.getSongId().equals(songIdToDelete)) {
                            iterator.remove();
                            System.out.println("Xóa bài hát thành công.");
                            break;
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void searchManagement(List<Singer> singers, List<Song> songs, Scanner scanner) {
        while (true) {
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên ca sĩ hoặc thể loại: ");
                    String searchTerm = scanner.nextLine();
                    System.out.println("Kết quả tìm kiếm bài hát:");
                    for (Song song : songs) {
                        if (song.getSinger().getSingerName().toLowerCase().contains(searchTerm.toLowerCase())
                                || song.getSinger().getGenre().toLowerCase().contains(searchTerm.toLowerCase())) {
                            song.displayData();
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên ca sĩ hoặc thể loại: ");
                    String singerSearchTerm = scanner.nextLine();
                    System.out.println("Kết quả tìm kiếm ca sĩ:");
                    for (Singer singer : singers) {
                        if (singer.getSingerName().toLowerCase().contains(singerSearchTerm.toLowerCase())
                                || singer.getGenre().toLowerCase().contains(singerSearchTerm.toLowerCase())) {
                            singer.displayData();
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 3:
                    Collections.sort(songs, Comparator.comparing(Song::getSongName));
                    System.out.println("Danh sách bài hát theo tên tăng dần:");
                    for (Song song : songs) {
                        song.displayData();
                        System.out.println("-------------------------");
                    }
                    break;
                case 4:
                    List<Song> newestSongs = new ArrayList<>(songs);
                    newestSongs.sort((s1, s2) -> s2.getCreatedDate().compareTo(s1.getCreatedDate()));
                    System.out.println("10 bài hát được đăng mới nhất:");
                    int count = 0;
                    for (Song song : newestSongs) {
                        if (count >= 10) {
                            break;
                        }
                        song.displayData();
                        System.out.println("-------------------------");
                        count++;
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}