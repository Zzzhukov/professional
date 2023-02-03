package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Boss;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.BossRepository;

public class EditBossService {
    private static final EditBossService EDIT_BOSS_SERVICE = new EditBossService();

    private EditBossService() {
    }

    public static EditBossService getInstance() {
        return EDIT_BOSS_SERVICE;
    }

    private final BossRepository bossRepository = BossRepository.getInstance();

    private Boss boss;

    public void updateBoss(String code, String fullName, String phone, String experience) {
        boss.setIdBoss(Long.parseLong(code));
        boss.setFullName(fullName);
        boss.setPhone(phone);
        boss.setExperience(experience);

        if (code.equals("0")){
            bossRepository.insertBoss(boss);
        }
        else {
            bossRepository.updateBoss(boss);
        }
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public void deleteBoss() {
        bossRepository.deleteBoss(boss.getIdBoss());
    }
}
