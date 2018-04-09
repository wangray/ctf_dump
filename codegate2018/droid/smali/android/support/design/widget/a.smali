.class Landroid/support/design/widget/a;
.super Ljava/lang/Object;


# static fields
.field static final a:Landroid/view/animation/Interpolator;

.field static final b:Landroid/view/animation/Interpolator;

.field static final c:Landroid/view/animation/Interpolator;

.field static final d:Landroid/view/animation/Interpolator;

.field static final e:Landroid/view/animation/Interpolator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    sput-object v0, Landroid/support/design/widget/a;->a:Landroid/view/animation/Interpolator;

    new-instance v0, Landroid/support/v4/i/b/b;

    invoke-direct {v0}, Landroid/support/v4/i/b/b;-><init>()V

    sput-object v0, Landroid/support/design/widget/a;->b:Landroid/view/animation/Interpolator;

    new-instance v0, Landroid/support/v4/i/b/a;

    invoke-direct {v0}, Landroid/support/v4/i/b/a;-><init>()V

    sput-object v0, Landroid/support/design/widget/a;->c:Landroid/view/animation/Interpolator;

    new-instance v0, Landroid/support/v4/i/b/c;

    invoke-direct {v0}, Landroid/support/v4/i/b/c;-><init>()V

    sput-object v0, Landroid/support/design/widget/a;->d:Landroid/view/animation/Interpolator;

    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    sput-object v0, Landroid/support/design/widget/a;->e:Landroid/view/animation/Interpolator;

    return-void
.end method
