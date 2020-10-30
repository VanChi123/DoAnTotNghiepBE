package com.mta.shop.controllers.message;

class Candidate {
    String maThiSinh;
    String tenThiSinh;
    float diemThiMon1;
    float diemThiMon2;
    float diemThiMon3;

    public Candidate(String maThiSinh, String tenThiSinh, float diemThiMon1, float diemThiMon2, float diemThiMon3) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.diemThiMon1 = diemThiMon1;
        this.diemThiMon2 = diemThiMon2;
        this.diemThiMon3 = diemThiMon3;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public float getDiemThiMon1() {
        return diemThiMon1;
    }

    public void setDiemThiMon1(float diemThiMon1) {
        this.diemThiMon1 = diemThiMon1;
    }

    public float getDiemThiMon2() {
        return diemThiMon2;
    }

    public void setDiemThiMon2(float diemThiMon2) {
        this.diemThiMon2 = diemThiMon2;
    }

    public float getDiemThiMon3() {
        return diemThiMon3;
    }

    public void setDiemThiMon3(float diemThiMon3) {
        this.diemThiMon3 = diemThiMon3;
    }
}

class CandidateException {
    static void validate(float diemThi, Candidate candidate) throws InvalidMarkException {
        if (diemThi > 10.0) {
            throw new InvalidMarkException("Thí sinh " + candidate.getTenThiSinh() + " có mã "+ candidate.getMaThiSinh()+ " có điểm "+ diemThi + "không hợp lệ");
        } else if (diemThi < 0.0){
            throw  new InvalidMarkException("Thí sinh " + candidate.getTenThiSinh() + " có mã "+ candidate.getMaThiSinh()+ " có điểm "+ diemThi + "không hợp lệ");
        }else {
            System.out.println(diemThi + "Hợp lệ");
        }
    }
}

class InvalidMarkException extends Exception {
    InvalidMarkException(String s) {
        super(s);
    }
}

public class Bai5Test{
    public static void main(String args[]) {
        Candidate candidate = new Candidate("SV01", "Vũ Quang Linh", 10, 11, (float)8.5);

        try {
            CandidateException.validate(candidate.diemThiMon1, candidate);
            CandidateException.validate(candidate.diemThiMon2, candidate);
            CandidateException.validate(candidate.diemThiMon3, candidate);
        } catch (Exception m) {
            System.out.println("Lỗi: " + m);
        }

        // test sinh viên thứ 2
//        Candidate candidateTwo = new Candidate("SV02", "NGuyễn văn a", 10, (float)9.0, (float)8.5);
//
//        try {
//            CandidateException.validate(candidate.diemThiMon1, candidateTwo);
//            CandidateException.validate(candidate.diemThiMon2, candidateTwo);
//            CandidateException.validate(candidate.diemThiMon3, candidateTwo);
//        } catch (Exception m) {
//            System.out.println("Lỗi: " + m);
//        }
    }
}
