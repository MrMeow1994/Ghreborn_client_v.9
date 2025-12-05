import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParticleDefinition {

    public static List<ParticleDefinition> cache = new ArrayList<>();

    static {
        // definition id 0
        final ParticleDefinition compCape = new ParticleDefinition();
        compCape.setStartVelocity(new ParticleVector(0, -1, 0));
        compCape.setEndVelocity(new ParticleVector(0, -1, 0));
        compCape.setGravity(new ParticleVector(0, 2 / 4, 0));
        compCape.setLifeSpan(19);
        compCape.setStartColor(0xeef5f1);
        compCape.setSpawnRate(4);
        compCape.setStartSize(1.10f);
        compCape.setEndSize(0);
        compCape.setStartAlpha(0.095f);
        compCape.updateSteps();
        compCape.setColorStep(0x000000);
        cache.add(compCape);

        // definition id 1
        final ParticleDefinition gandalfSet = new ParticleDefinition();
        gandalfSet.setStartVelocity(new ParticleVector(0, 0, 0));
        gandalfSet.setEndVelocity(new ParticleVector(0, 0, 0));
        gandalfSet.setGravity(new ParticleVector(0, 2, 0));
        gandalfSet.setLifeSpan(10);
        gandalfSet.setStartColor(0x139599);
        gandalfSet.setSpawnRate(5);
        gandalfSet.setStartSize(1.05f);
        gandalfSet.setEndSize(0);
        gandalfSet.setStartAlpha(0.075f);
        gandalfSet.updateSteps();
        gandalfSet.setColorStep(0x000000);
        cache.add(gandalfSet);

        // definition id 2
        final ParticleDefinition gimiliSet = new ParticleDefinition();
        gimiliSet.setStartVelocity(new ParticleVector(0, 0, 0));
        gimiliSet.setEndVelocity(new ParticleVector(0, 0, 0));
        gimiliSet.setGravity(new ParticleVector(0, 2, 0));
        gimiliSet.setLifeSpan(15);
        gimiliSet.setStartColor(0xff0000);
        gimiliSet.setSpawnRate(7);
        gimiliSet.setStartSize(1.10f);
        gimiliSet.setEndSize(0);
        gimiliSet.setStartAlpha(0.085f);
        gimiliSet.updateSteps();
        gimiliSet.setColorStep(0x000000);
        cache.add(gimiliSet);

        // definition id 3
        final ParticleDefinition legolasSet = new ParticleDefinition();
        legolasSet.setStartVelocity(new ParticleVector(0, 0, 0));
        legolasSet.setEndVelocity(new ParticleVector(0, 0, 0));
        legolasSet.setGravity(new ParticleVector(0, 2, 0));
        legolasSet.setLifeSpan(12);
        legolasSet.setStartColor(0x416d14);
        legolasSet.setSpawnRate(8);
        legolasSet.setStartSize(1.15f);
        legolasSet.setEndSize(0);
        legolasSet.setStartAlpha(0.075f);
        legolasSet.updateSteps();
        legolasSet.setColorStep(0x000000);
        cache.add(legolasSet);

        // definition id 4
        final ParticleDefinition ownerCape = new ParticleDefinition();
        ownerCape.setStartVelocity(new ParticleVector(0, 0, 0));
        ownerCape.setEndVelocity(new ParticleVector(0, 0, 0));
        ownerCape.setGravity(new ParticleVector(0, 2, 0));
        ownerCape.setLifeSpan(12);
        ownerCape.setStartColor(0xf59805);
        ownerCape.setSpawnRate(8);
        ownerCape.setStartSize(1.15f);
        ownerCape.setEndSize(0);
        ownerCape.setStartAlpha(0.075f);
        ownerCape.updateSteps();
        ownerCape.setColorStep(0x000000);
        cache.add(ownerCape);

        // definition id 5
        final ParticleDefinition attackCape = new ParticleDefinition();
        attackCape.setStartVelocity(new ParticleVector(0, 0, 0));
        attackCape.setEndVelocity(new ParticleVector(0, 0, 0));
        attackCape.setGravity(new ParticleVector(0, -2, 0));
        attackCape.setLifeSpan(12);
        attackCape.setStartColor(0xf4e305);
        attackCape.setSpawnRate(8);
        attackCape.setStartSize(1.15f);
        attackCape.setEndSize(0);
        attackCape.setStartAlpha(0.075f);
        attackCape.updateSteps();
        attackCape.setColorStep(0x000000);
        cache.add(attackCape);

        // definition id 6
        final ParticleDefinition strengthCape = new ParticleDefinition();
        strengthCape.setStartVelocity(new ParticleVector(0, 0, 0));
        strengthCape.setEndVelocity(new ParticleVector(0, 0, 0));
        strengthCape.setGravity(new ParticleVector(0, -2, 0));
        strengthCape.setLifeSpan(12);
        strengthCape.setStartColor(0x892d27);
        strengthCape.setSpawnRate(8);
        strengthCape.setStartSize(1.15f);
        strengthCape.setEndSize(0);
        strengthCape.setStartAlpha(0.075f);
        strengthCape.updateSteps();
        strengthCape.setColorStep(0x000000);
        cache.add(strengthCape);

        // definition id 7
        final ParticleDefinition rangedCape = new ParticleDefinition();
        rangedCape.setStartVelocity(new ParticleVector(0, 0, 0));
        rangedCape.setEndVelocity(new ParticleVector(0, 0, 0));
        rangedCape.setGravity(new ParticleVector(0, -2, 0));
        rangedCape.setLifeSpan(12);
        rangedCape.setStartColor(0x7e4542);
        rangedCape.setSpawnRate(8);
        rangedCape.setStartSize(1.15f);
        rangedCape.setEndSize(0);
        rangedCape.setStartAlpha(0.075f);
        rangedCape.updateSteps();
        rangedCape.setColorStep(0x000000);
        cache.add(rangedCape);

        // definition id 8
        final ParticleDefinition magicCape = new ParticleDefinition();
        magicCape.setStartVelocity(new ParticleVector(0, 0, 0));
        magicCape.setEndVelocity(new ParticleVector(0, 0, 0));
        magicCape.setGravity(new ParticleVector(0, -2, 0));
        magicCape.setLifeSpan(12);
        magicCape.setStartColor(0xc4a33d);
        magicCape.setSpawnRate(8);
        magicCape.setStartSize(1.15f);
        magicCape.setEndSize(0);
        magicCape.setStartAlpha(0.075f);
        magicCape.updateSteps();
        magicCape.setColorStep(0x000000);
        cache.add(magicCape);

        // definition id 9
        final ParticleDefinition miningCape = new ParticleDefinition();
        miningCape.setStartVelocity(new ParticleVector(0, 0, 0));
        miningCape.setEndVelocity(new ParticleVector(0, 0, 0));
        miningCape.setGravity(new ParticleVector(0, -2, 0));
        miningCape.setLifeSpan(12);
        miningCape.setStartColor(0x98bad2);
        miningCape.setSpawnRate(8);
        miningCape.setStartSize(1.15f);
        miningCape.setEndSize(0);
        miningCape.setStartAlpha(0.075f);
        miningCape.updateSteps();
        miningCape.setColorStep(0x000000);
        cache.add(miningCape);

        // definition id 10
        final ParticleDefinition hunterCape = new ParticleDefinition();
        hunterCape.setStartVelocity(new ParticleVector(0, 0, 0));
        hunterCape.setEndVelocity(new ParticleVector(0, 0, 0));
        hunterCape.setGravity(new ParticleVector(0, -2, 0));
        hunterCape.setLifeSpan(12);
        hunterCape.setStartColor(0x261402);
        hunterCape.setSpawnRate(8);
        hunterCape.setStartSize(1.15f);
        hunterCape.setEndSize(0);
        hunterCape.setStartAlpha(0.075f);
        hunterCape.updateSteps();
        hunterCape.setColorStep(0x000000);
        cache.add(hunterCape);

        // definition id 11
        final ParticleDefinition farmingCape = new ParticleDefinition();
        farmingCape.setStartVelocity(new ParticleVector(0, 0, 0));
        farmingCape.setEndVelocity(new ParticleVector(0, 0, 0));
        farmingCape.setGravity(new ParticleVector(0, -2, 0));
        farmingCape.setLifeSpan(12);
        farmingCape.setStartColor(0xe8fc98);
        farmingCape.setSpawnRate(8);
        farmingCape.setStartSize(1.15f);
        farmingCape.setEndSize(0);
        farmingCape.setStartAlpha(0.075f);
        farmingCape.updateSteps();
        farmingCape.setColorStep(0x000000);
        cache.add(farmingCape);

        // definition id 12
        final ParticleDefinition thievingCape = new ParticleDefinition();
        thievingCape.setStartVelocity(new ParticleVector(0, 0, 0));
        thievingCape.setEndVelocity(new ParticleVector(0, 0, 0));
        thievingCape.setGravity(new ParticleVector(0, -2, 0));
        thievingCape.setLifeSpan(12);
        thievingCape.setStartColor(0x2d2e2a);
        thievingCape.setSpawnRate(8);
        thievingCape.setSpawnRate(8);
        thievingCape.setStartSize(1.15f);
        thievingCape.setEndSize(0);
        thievingCape.setStartAlpha(0.075f);
        thievingCape.updateSteps();
        thievingCape.setColorStep(0x000000);
        cache.add(thievingCape);

        // definition id 13
        final ParticleDefinition woodcuttingCape = new ParticleDefinition();
        woodcuttingCape.setStartVelocity(new ParticleVector(0, 0, 0));
        woodcuttingCape.setEndVelocity(new ParticleVector(0, 0, 0));
        woodcuttingCape.setGravity(new ParticleVector(0, -2, 0));
        woodcuttingCape.setLifeSpan(12);
        woodcuttingCape.setStartColor(0x2f5b2d);
        woodcuttingCape.setSpawnRate(8);
        woodcuttingCape.setStartSize(1.15f);
        woodcuttingCape.setEndSize(0);
        woodcuttingCape.setStartAlpha(0.075f);
        woodcuttingCape.updateSteps();
        woodcuttingCape.setColorStep(0x000000);
        cache.add(woodcuttingCape);

        // definition id 14
        final ParticleDefinition reaper = new ParticleDefinition();
        reaper.setStartVelocity(new ParticleVector(0, 0, 0));
        reaper.setEndVelocity(new ParticleVector(0, 0, 0));
        reaper.setGravity(new ParticleVector(0, -2, 0));
        reaper.setLifeSpan(12);
        reaper.setStartColor(0x000000);
        reaper.setSpawnRate(8);
        reaper.setStartSize(1.15f);
        reaper.setEndSize(0);
        reaper.setStartAlpha(0.075f);
        reaper.updateSteps();
        reaper.setColorStep(0x000000);
        cache.add(reaper);

        // definition id 15
        final ParticleDefinition malevolence = new ParticleDefinition();
        malevolence.setStartVelocity(new ParticleVector(0, 0, 0));
        malevolence.setEndVelocity(new ParticleVector(0, 0, 0));
        malevolence.setGravity(new ParticleVector(0, -2, 0));
        malevolence.setLifeSpan(12);
        malevolence.setStartColor(0x8b0000);
        malevolence.setSpawnRate(8);
        malevolence.setStartSize(1.15f);
        malevolence.setEndSize(0);
        malevolence.setStartAlpha(0.075f);
        malevolence.updateSteps();
        malevolence.setColorStep(0x000000);
        cache.add(malevolence);

        // definition id 16
        final ParticleDefinition noctoriousStaff = new ParticleDefinition();
        noctoriousStaff.setStartVelocity(new ParticleVector(0, 0, 0));
        noctoriousStaff.setEndVelocity(new ParticleVector(0, 0, 0));
        noctoriousStaff.setGravity(new ParticleVector(0, -2, 0));
        noctoriousStaff.setLifeSpan(12);
        noctoriousStaff.setStartColor(0xf0ad3f);
        noctoriousStaff.setSpawnRate(8);
        noctoriousStaff.setStartSize(1.15f);
        noctoriousStaff.setEndSize(0);
        noctoriousStaff.setStartAlpha(0.075f);
        noctoriousStaff.updateSteps();
        noctoriousStaff.setColorStep(0x000000);
        cache.add(noctoriousStaff);

        // definition id 17
        final ParticleDefinition spaceIntruder = new ParticleDefinition();
        spaceIntruder.setStartVelocity(new ParticleVector(0, 0, 0));
        spaceIntruder.setEndVelocity(new ParticleVector(0, 0, 0));
        spaceIntruder.setGravity(new ParticleVector(0, -2, 0));
        spaceIntruder.setLifeSpan(12);
        spaceIntruder.setStartColor(0x00e6f2);
        spaceIntruder.setSpawnRate(8);
        spaceIntruder.setStartSize(1.15f);
        spaceIntruder.setEndSize(0);
        spaceIntruder.setStartAlpha(0.075f);
        spaceIntruder.updateSteps();
        spaceIntruder.setColorStep(0x000000);
        cache.add(spaceIntruder);

        // definition id 18
        final ParticleDefinition CustomStaff = new ParticleDefinition();
        CustomStaff.setStartVelocity(new ParticleVector(0, 0, 0));
        CustomStaff.setEndVelocity(new ParticleVector(0, 0, 0));
        CustomStaff.setGravity(new ParticleVector(0, -2, 0));
        CustomStaff.setLifeSpan(12);
        CustomStaff.setStartColor(0x00e6f2);
        CustomStaff.setSpawnRate(8);
        CustomStaff.setStartSize(1.15f);
        CustomStaff.setEndSize(0);
        CustomStaff.setStartAlpha(0.075f);
        CustomStaff.updateSteps();
        CustomStaff.setColorStep(0x000000);
        cache.add(CustomStaff);

        // definition id 19
        final ParticleDefinition DungCape = new ParticleDefinition();
        DungCape.setStartVelocity(new ParticleVector(0, 0, 0));
        DungCape.setEndVelocity(new ParticleVector(0, 0, 0));
        DungCape.setGravity(new ParticleVector(0, -2, 0));
        DungCape.setLifeSpan(19);
        DungCape.setStartColor(0x000000);
        DungCape.setSpawnRate(8);
        DungCape.setStartSize(1.15f);
        DungCape.setEndSize(0);
        DungCape.setStartAlpha(0.075f);
        DungCape.updateSteps();
        DungCape.setColorStep(0x000000);
        cache.add(DungCape);
    }

    private ParticleVector gravity;

    private float startSize = 1f;
    private float endSize = 1f;

    private int startColor = -1;
    private final int endColor = -1;

    private ParticleVector startVelocity = ParticleVector.EMPTY;
    private ParticleVector endVelocity = ParticleVector.EMPTY;

    private final SpawnShape spawnShape = new PointSpawnShape(ParticleVector.EMPTY);

    private float startAlpha = 1f;
    private float endAlpha = 0.05f;

    private int lifeSpan = 1;
    private int spawnRate = 1;
    private Sprite sprite;
    private ParticleVector velocityStep;
    private int colorStep;
    private float sizeStep;
    private float alphaStep;

    public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public final ParticleVector getStartVelocity() {
        return new ParticleVector(this.startVelocity.getX() + randomWithRange(-1, 1), this.startVelocity.getY() + randomWithRange(0, 0), this.startVelocity.getZ() + randomWithRange(-1, 1));
    }

    public final void updateSteps() {
        this.sizeStep = (endSize - startSize) / (lifeSpan * 1f);
        this.colorStep = (endColor - startColor) / lifeSpan;
        this.velocityStep = endVelocity.subtract(startVelocity).divide(lifeSpan);
        this.alphaStep = (endAlpha - startAlpha) / lifeSpan;
    }
}