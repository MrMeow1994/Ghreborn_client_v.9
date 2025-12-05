import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Particle {

    private int age;
    private int color;
    private float size;
    private final ParticleVector velocity;
    private float alpha;
    private final float oldAlpha;
    private boolean dead;
    private ParticleDefinition def;
    private final ParticleVector position;

    public final void tick() {
        if (def != null) {
            ++age;
            if (age >= def.getLifeSpan()) {
                dead = true;
            } else {
                color += def.getColorStep();
                size += def.getSizeStep();
                position.addLocal(velocity);
                velocity.addLocal(def.getVelocityStep());
                alpha += def.getAlphaStep();
                if (def.getGravity() != null) {
                    position.addLocal(def.getGravity());
                }
                if (alpha <= 0f) {
                    alpha = 0f;
                }
            }
        }
    }

    public Particle(ParticleDefinition def, ParticleVector position) {
        this(def.getStartColor(), def.getStartSize(), def.getStartVelocity().clone(), def.getSpawnShape().divide().addLocal(position), def.getStartAlpha());
        this.def = def;
    }

    private Particle(int color, float size, ParticleVector velocity, ParticleVector position, float alpha) {
        this.age = 0;
        this.dead = false;
        this.def = null;
        this.color = color;
        this.size = size;
        this.velocity = velocity;
        this.position = position;
        this.alpha = alpha;
        this.oldAlpha = alpha;
    }
}