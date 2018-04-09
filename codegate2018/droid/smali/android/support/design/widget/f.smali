.class Landroid/support/design/widget/f;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/design/widget/f$a;,
        Landroid/support/design/widget/f$b;,
        Landroid/support/design/widget/f$d;,
        Landroid/support/design/widget/f$e;,
        Landroid/support/design/widget/f$c;
    }
.end annotation


# static fields
.field static final a:Landroid/view/animation/Interpolator;

.field static final j:[I

.field static final k:[I

.field static final l:[I

.field static final m:[I


# instance fields
.field b:I

.field c:Landroid/support/design/widget/j;

.field d:Landroid/graphics/drawable/Drawable;

.field e:Landroid/graphics/drawable/Drawable;

.field f:Landroid/support/design/widget/c;

.field g:Landroid/graphics/drawable/Drawable;

.field h:F

.field i:F

.field final n:Landroid/support/design/widget/t;

.field final o:Landroid/support/design/widget/k;

.field private final p:Landroid/support/design/widget/m;

.field private q:F

.field private final r:Landroid/graphics/Rect;

.field private s:Landroid/view/ViewTreeObserver$OnPreDrawListener;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v1, 0x2

    const/4 v2, 0x0

    sget-object v0, Landroid/support/design/widget/a;->c:Landroid/view/animation/Interpolator;

    sput-object v0, Landroid/support/design/widget/f;->a:Landroid/view/animation/Interpolator;

    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/design/widget/f;->j:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_1

    sput-object v0, Landroid/support/design/widget/f;->k:[I

    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x101009e

    aput v1, v0, v2

    sput-object v0, Landroid/support/design/widget/f;->l:[I

    new-array v0, v2, [I

    sput-object v0, Landroid/support/design/widget/f;->m:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x10100a7
        0x101009e
    .end array-data

    :array_1
    .array-data 4
        0x101009c
        0x101009e
    .end array-data
.end method

.method constructor <init>(Landroid/support/design/widget/t;Landroid/support/design/widget/k;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Landroid/support/design/widget/f;->b:I

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/design/widget/f;->r:Landroid/graphics/Rect;

    iput-object p1, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    iput-object p2, p0, Landroid/support/design/widget/f;->o:Landroid/support/design/widget/k;

    new-instance v0, Landroid/support/design/widget/m;

    invoke-direct {v0}, Landroid/support/design/widget/m;-><init>()V

    iput-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    sget-object v1, Landroid/support/design/widget/f;->j:[I

    new-instance v2, Landroid/support/design/widget/f$b;

    invoke-direct {v2, p0}, Landroid/support/design/widget/f$b;-><init>(Landroid/support/design/widget/f;)V

    invoke-direct {p0, v2}, Landroid/support/design/widget/f;->a(Landroid/support/design/widget/f$e;)Landroid/animation/ValueAnimator;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/m;->a([ILandroid/animation/ValueAnimator;)V

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    sget-object v1, Landroid/support/design/widget/f;->k:[I

    new-instance v2, Landroid/support/design/widget/f$b;

    invoke-direct {v2, p0}, Landroid/support/design/widget/f$b;-><init>(Landroid/support/design/widget/f;)V

    invoke-direct {p0, v2}, Landroid/support/design/widget/f;->a(Landroid/support/design/widget/f$e;)Landroid/animation/ValueAnimator;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/m;->a([ILandroid/animation/ValueAnimator;)V

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    sget-object v1, Landroid/support/design/widget/f;->l:[I

    new-instance v2, Landroid/support/design/widget/f$d;

    invoke-direct {v2, p0}, Landroid/support/design/widget/f$d;-><init>(Landroid/support/design/widget/f;)V

    invoke-direct {p0, v2}, Landroid/support/design/widget/f;->a(Landroid/support/design/widget/f$e;)Landroid/animation/ValueAnimator;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/m;->a([ILandroid/animation/ValueAnimator;)V

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    sget-object v1, Landroid/support/design/widget/f;->m:[I

    new-instance v2, Landroid/support/design/widget/f$a;

    invoke-direct {v2, p0}, Landroid/support/design/widget/f$a;-><init>(Landroid/support/design/widget/f;)V

    invoke-direct {p0, v2}, Landroid/support/design/widget/f;->a(Landroid/support/design/widget/f$e;)Landroid/animation/ValueAnimator;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/m;->a([ILandroid/animation/ValueAnimator;)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getRotation()F

    move-result v0

    iput v0, p0, Landroid/support/design/widget/f;->q:F

    return-void
.end method

.method private a(Landroid/support/design/widget/f$e;)Landroid/animation/ValueAnimator;
    .locals 4

    new-instance v0, Landroid/animation/ValueAnimator;

    invoke-direct {v0}, Landroid/animation/ValueAnimator;-><init>()V

    sget-object v1, Landroid/support/design/widget/f;->a:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    const/4 v1, 0x2

    new-array v1, v1, [F

    fill-array-data v1, :array_0

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    return-object v0

    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private static b(I)Landroid/content/res/ColorStateList;
    .locals 5

    const/4 v1, 0x3

    const/4 v4, 0x0

    new-array v0, v1, [[I

    new-array v1, v1, [I

    sget-object v2, Landroid/support/design/widget/f;->k:[I

    aput-object v2, v0, v4

    aput p0, v1, v4

    const/4 v2, 0x1

    sget-object v3, Landroid/support/design/widget/f;->j:[I

    aput-object v3, v0, v2

    aput p0, v1, v2

    const/4 v2, 0x2

    new-array v3, v4, [I

    aput-object v3, v0, v2

    aput v4, v1, v2

    new-instance v2, Landroid/content/res/ColorStateList;

    invoke-direct {v2, v0, v1}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v2
.end method

.method private o()V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    if-nez v0, :cond_0

    new-instance v0, Landroid/support/design/widget/f$3;

    invoke-direct {v0, p0}, Landroid/support/design/widget/f$3;-><init>(Landroid/support/design/widget/f;)V

    iput-object v0, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    :cond_0
    return-void
.end method

.method private p()Z
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-static {v0}, Landroid/support/v4/i/q;->u(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->isInEditMode()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private q()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, 0x1

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-ne v0, v1, :cond_0

    iget v0, p0, Landroid/support/design/widget/f;->q:F

    const/high16 v1, 0x42b40000    # 90.0f

    rem-float/2addr v0, v1

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_3

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getLayerType()I

    move-result v0

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v2, v3}, Landroid/support/design/widget/t;->setLayerType(ILandroid/graphics/Paint;)V

    :cond_0
    :goto_0
    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    iget v1, p0, Landroid/support/design/widget/f;->q:F

    neg-float v1, v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/j;->a(F)V

    :cond_1
    iget-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    iget v1, p0, Landroid/support/design/widget/f;->q:F

    neg-float v1, v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/c;->b(F)V

    :cond_2
    return-void

    :cond_3
    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getLayerType()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v3}, Landroid/support/design/widget/t;->setLayerType(ILandroid/graphics/Paint;)V

    goto :goto_0
.end method


# virtual methods
.method a()F
    .locals 1

    iget v0, p0, Landroid/support/design/widget/f;->h:F

    return v0
.end method

.method a(ILandroid/content/res/ColorStateList;)Landroid/support/design/widget/c;
    .locals 6

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Landroid/support/design/widget/f;->i()Landroid/support/design/widget/c;

    move-result-object v1

    sget v2, Landroid/support/design/a$c;->design_fab_stroke_top_outer_color:I

    invoke-static {v0, v2}, Landroid/support/v4/b/a;->c(Landroid/content/Context;I)I

    move-result v2

    sget v3, Landroid/support/design/a$c;->design_fab_stroke_top_inner_color:I

    invoke-static {v0, v3}, Landroid/support/v4/b/a;->c(Landroid/content/Context;I)I

    move-result v3

    sget v4, Landroid/support/design/a$c;->design_fab_stroke_end_inner_color:I

    invoke-static {v0, v4}, Landroid/support/v4/b/a;->c(Landroid/content/Context;I)I

    move-result v4

    sget v5, Landroid/support/design/a$c;->design_fab_stroke_end_outer_color:I

    invoke-static {v0, v5}, Landroid/support/v4/b/a;->c(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/support/design/widget/c;->a(IIII)V

    int-to-float v0, p1

    invoke-virtual {v1, v0}, Landroid/support/design/widget/c;->a(F)V

    invoke-virtual {v1, p2}, Landroid/support/design/widget/c;->a(Landroid/content/res/ColorStateList;)V

    return-object v1
.end method

.method final a(F)V
    .locals 1

    iget v0, p0, Landroid/support/design/widget/f;->h:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    iput p1, p0, Landroid/support/design/widget/f;->h:F

    iget v0, p0, Landroid/support/design/widget/f;->i:F

    invoke-virtual {p0, p1, v0}, Landroid/support/design/widget/f;->a(FF)V

    :cond_0
    return-void
.end method

.method a(FF)V
    .locals 2

    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    iget v1, p0, Landroid/support/design/widget/f;->i:F

    add-float/2addr v1, p1

    invoke-virtual {v0, p1, v1}, Landroid/support/design/widget/j;->a(FF)V

    invoke-virtual {p0}, Landroid/support/design/widget/f;->e()V

    :cond_0
    return-void
.end method

.method a(I)V
    .locals 2

    iget-object v0, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    invoke-static {p1}, Landroid/support/design/widget/f;->b(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    :cond_0
    return-void
.end method

.method a(Landroid/content/res/ColorStateList;)V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p1}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    :cond_0
    iget-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    invoke-virtual {v0, p1}, Landroid/support/design/widget/c;->a(Landroid/content/res/ColorStateList;)V

    :cond_1
    return-void
.end method

.method a(Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;II)V
    .locals 8

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v7, 0x0

    invoke-virtual {p0}, Landroid/support/design/widget/f;->k()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/c/a/a;->f(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p1}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    if-eqz p2, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p2}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    :cond_0
    invoke-virtual {p0}, Landroid/support/design/widget/f;->k()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/c/a/a;->f(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    iget-object v0, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    invoke-static {p3}, Landroid/support/design/widget/f;->b(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    if-lez p4, :cond_1

    invoke-virtual {p0, p4, p1}, Landroid/support/design/widget/f;->a(ILandroid/content/res/ColorStateList;)Landroid/support/design/widget/c;

    move-result-object v0

    iput-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    const/4 v0, 0x3

    new-array v0, v0, [Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    aput-object v1, v0, v7

    iget-object v1, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    aput-object v1, v0, v2

    iget-object v1, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    aput-object v1, v0, v3

    :goto_0
    new-instance v1, Landroid/graphics/drawable/LayerDrawable;

    invoke-direct {v1, v0}, Landroid/graphics/drawable/LayerDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    iput-object v1, p0, Landroid/support/design/widget/f;->g:Landroid/graphics/drawable/Drawable;

    new-instance v0, Landroid/support/design/widget/j;

    iget-object v1, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v1}, Landroid/support/design/widget/t;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Landroid/support/design/widget/f;->g:Landroid/graphics/drawable/Drawable;

    iget-object v3, p0, Landroid/support/design/widget/f;->o:Landroid/support/design/widget/k;

    invoke-interface {v3}, Landroid/support/design/widget/k;->a()F

    move-result v3

    iget v4, p0, Landroid/support/design/widget/f;->h:F

    iget v5, p0, Landroid/support/design/widget/f;->h:F

    iget v6, p0, Landroid/support/design/widget/f;->i:F

    add-float/2addr v5, v6

    invoke-direct/range {v0 .. v5}, Landroid/support/design/widget/j;-><init>(Landroid/content/Context;Landroid/graphics/drawable/Drawable;FFF)V

    iput-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    invoke-virtual {v0, v7}, Landroid/support/design/widget/j;->a(Z)V

    iget-object v0, p0, Landroid/support/design/widget/f;->o:Landroid/support/design/widget/k;

    iget-object v1, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    invoke-interface {v0, v1}, Landroid/support/design/widget/k;->a(Landroid/graphics/drawable/Drawable;)V

    return-void

    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/design/widget/f;->f:Landroid/support/design/widget/c;

    new-array v0, v3, [Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    aput-object v1, v0, v7

    iget-object v1, p0, Landroid/support/design/widget/f;->e:Landroid/graphics/drawable/Drawable;

    aput-object v1, v0, v2

    goto :goto_0
.end method

.method a(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->d:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p1}, Landroid/support/v4/c/a/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    :cond_0
    return-void
.end method

.method a(Landroid/graphics/Rect;)V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    invoke-virtual {v0, p1}, Landroid/support/design/widget/j;->getPadding(Landroid/graphics/Rect;)Z

    return-void
.end method

.method a(Landroid/support/design/widget/f$c;Z)V
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/support/design/widget/f;->n()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    invoke-direct {p0}, Landroid/support/design/widget/f;->p()Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    iput v0, p0, Landroid/support/design/widget/f;->b:I

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    sget-object v1, Landroid/support/design/widget/a;->c:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/support/design/widget/f$1;

    invoke-direct {v1, p0, p2, p1}, Landroid/support/design/widget/f$1;-><init>(Landroid/support/design/widget/f;ZLandroid/support/design/widget/f$c;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    goto :goto_0

    :cond_2
    iget-object v1, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    if-eqz p2, :cond_3

    const/16 v0, 0x8

    :goto_1
    invoke-virtual {v1, v0, p2}, Landroid/support/design/widget/t;->a(IZ)V

    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/support/design/widget/f$c;->b()V

    goto :goto_0

    :cond_3
    const/4 v0, 0x4

    goto :goto_1
.end method

.method a([I)V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    invoke-virtual {v0, p1}, Landroid/support/design/widget/m;->a([I)V

    return-void
.end method

.method b()V
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->p:Landroid/support/design/widget/m;

    invoke-virtual {v0}, Landroid/support/design/widget/m;->a()V

    return-void
.end method

.method final b(F)V
    .locals 1

    iget v0, p0, Landroid/support/design/widget/f;->i:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    iput p1, p0, Landroid/support/design/widget/f;->i:F

    iget v0, p0, Landroid/support/design/widget/f;->h:F

    invoke-virtual {p0, v0, p1}, Landroid/support/design/widget/f;->a(FF)V

    :cond_0
    return-void
.end method

.method b(Landroid/graphics/Rect;)V
    .locals 0

    return-void
.end method

.method b(Landroid/support/design/widget/f$c;Z)V
    .locals 4

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Landroid/support/design/widget/f;->m()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    invoke-direct {p0}, Landroid/support/design/widget/f;->p()Z

    move-result v0

    if-eqz v0, :cond_3

    const/4 v0, 0x2

    iput v0, p0, Landroid/support/design/widget/f;->b:I

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/t;->setAlpha(F)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/t;->setScaleY(F)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/t;->setScaleX(F)V

    :cond_2
    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    sget-object v1, Landroid/support/design/widget/a;->d:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/support/design/widget/f$2;

    invoke-direct {v1, p0, p2, p1}, Landroid/support/design/widget/f$2;-><init>(Landroid/support/design/widget/f;ZLandroid/support/design/widget/f$c;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    goto :goto_0

    :cond_3
    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2}, Landroid/support/design/widget/t;->a(IZ)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v2}, Landroid/support/design/widget/t;->setAlpha(F)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v2}, Landroid/support/design/widget/t;->setScaleY(F)V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0, v2}, Landroid/support/design/widget/t;->setScaleX(F)V

    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/support/design/widget/f$c;->a()V

    goto :goto_0
.end method

.method final c()Landroid/graphics/drawable/Drawable;
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/f;->g:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method d()V
    .locals 0

    return-void
.end method

.method final e()V
    .locals 5

    iget-object v0, p0, Landroid/support/design/widget/f;->r:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroid/support/design/widget/f;->a(Landroid/graphics/Rect;)V

    invoke-virtual {p0, v0}, Landroid/support/design/widget/f;->b(Landroid/graphics/Rect;)V

    iget-object v1, p0, Landroid/support/design/widget/f;->o:Landroid/support/design/widget/k;

    iget v2, v0, Landroid/graphics/Rect;->left:I

    iget v3, v0, Landroid/graphics/Rect;->top:I

    iget v4, v0, Landroid/graphics/Rect;->right:I

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    invoke-interface {v1, v2, v3, v4, v0}, Landroid/support/design/widget/k;->a(IIII)V

    return-void
.end method

.method f()V
    .locals 2

    invoke-virtual {p0}, Landroid/support/design/widget/f;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Landroid/support/design/widget/f;->o()V

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    iget-object v1, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    :cond_0
    return-void
.end method

.method g()V
    .locals 2

    iget-object v0, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    iget-object v1, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/design/widget/f;->s:Landroid/view/ViewTreeObserver$OnPreDrawListener;

    :cond_0
    return-void
.end method

.method h()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method i()Landroid/support/design/widget/c;
    .locals 1

    new-instance v0, Landroid/support/design/widget/c;

    invoke-direct {v0}, Landroid/support/design/widget/c;-><init>()V

    return-object v0
.end method

.method j()V
    .locals 2

    iget-object v0, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v0}, Landroid/support/design/widget/t;->getRotation()F

    move-result v0

    iget v1, p0, Landroid/support/design/widget/f;->q:F

    cmpl-float v1, v1, v0

    if-eqz v1, :cond_0

    iput v0, p0, Landroid/support/design/widget/f;->q:F

    invoke-direct {p0}, Landroid/support/design/widget/f;->q()V

    :cond_0
    return-void
.end method

.method k()Landroid/graphics/drawable/GradientDrawable;
    .locals 2

    invoke-virtual {p0}, Landroid/support/design/widget/f;->l()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    return-object v0
.end method

.method l()Landroid/graphics/drawable/GradientDrawable;
    .locals 1

    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    return-object v0
.end method

.method m()Z
    .locals 4

    const/4 v1, 0x0

    const/4 v0, 0x1

    iget-object v2, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v2}, Landroid/support/design/widget/t;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_2

    iget v2, p0, Landroid/support/design/widget/f;->b:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    iget v2, p0, Landroid/support/design/widget/f;->b:I

    if-ne v2, v0, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method n()Z
    .locals 4

    const/4 v1, 0x0

    const/4 v0, 0x1

    iget-object v2, p0, Landroid/support/design/widget/f;->n:Landroid/support/design/widget/t;

    invoke-virtual {v2}, Landroid/support/design/widget/t;->getVisibility()I

    move-result v2

    if-nez v2, :cond_2

    iget v2, p0, Landroid/support/design/widget/f;->b:I

    if-ne v2, v0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    iget v2, p0, Landroid/support/design/widget/f;->b:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    move v0, v1

    goto :goto_0
.end method
