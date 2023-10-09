package Exam_Advance.ra.model;

import java.util.*;
import java.text.SimpleDateFormat;
public class Song {
    private static int lastSongId = 0;
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        songId = generateSongId();
        createdDate = new Date();
    }
    public Song(String songName, String descriptions, Singer singer, String songWriter) {
        this();
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
    }
    private String generateSongId() {
        lastSongId++;
        return "S" + String.format("%03d", lastSongId);
    }
    public String getSongId() {
        return songId;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public Singer getSinger() {
        return singer;
    }
    public void setSinger(Singer singer) {
        this.singer = singer;
    }
    public String getSongWriter() {
        return songWriter;
    }
    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public boolean isSongStatus() {
        return songStatus;
    }
    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
    public void inputData(List<Singer> singers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên bài hát: ");
        songName = scanner.nextLine();
        System.out.print("Nhập mô tả bài hát: ");
        descriptions = scanner.nextLine();
        System.out.print("Nhập người sáng tác: ");
        songWriter = scanner.nextLine();

        if (singers.isEmpty()) {
            System.out.println("Không có ca sĩ nào. Bạn cần thêm ca sĩ trước.");
            return;
        }

        System.out.println("Danh sách ca sĩ:");
        for (Singer s : singers) {
            System.out.println(s.getSingerId() + ". " + s.getSingerName());
        }

        System.out.print("Nhập mã số ca sĩ (id) cho bài hát: ");
        int singerId = scanner.nextInt();
        scanner.nextLine();

        for (Singer s : singers) {
            if (s.getSingerId() == singerId) {
                singer = s;
                break;
            }
        }
    }
    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ: " + singer.getSingerName());
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + sdf.format(createdDate));
        System.out.println("Trạng thái: " + (songStatus ? "Hoạt động" : "Đang Hoạt Động."));
    }
}