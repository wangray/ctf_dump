.class Landroid/support/v7/widget/aj;
.super Landroid/support/v7/widget/av$g;

# interfaces
.implements Landroid/support/v7/widget/av$l;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/aj$b;,
        Landroid/support/v7/widget/aj$a;
    }
.end annotation


# static fields
.field private static final g:[I

.field private static final h:[I


# instance fields
.field private final A:[I

.field private final B:Landroid/animation/ValueAnimator;

.field private C:I

.field private final D:Ljava/lang/Runnable;

.field private final E:Landroid/support/v7/widget/av$m;

.field a:I

.field b:I

.field c:F

.field d:I

.field e:I

.field f:F

.field private final i:I

.field private final j:I

.field private final k:Landroid/graphics/drawable/StateListDrawable;

.field private final l:Landroid/graphics/drawable/Drawable;

.field private final m:I

.field private final n:I

.field private final o:Landroid/graphics/drawable/StateListDrawable;

.field private final p:Landroid/graphics/drawable/Drawable;

.field private final q:I

.field private final r:I

.field private s:I

.field private t:I

.field private u:Landroid/support/v7/widget/av;

.field private v:Z

.field private w:Z

.field private x:I

.field private y:I

.field private final z:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x10100a7

    aput v1, v0, v2

    sput-object v0, Landroid/support/v7/widget/aj;->g:[I

    new-array v0, v2, [I

    sput-object v0, Landroid/support/v7/widget/aj;->h:[I

    return-void
.end method

.method constructor <init>(Landroid/support/v7/widget/av;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;III)V
    .locals 5

    const/4 v4, 0x0

    const/16 v3, 0xff

    const/4 v2, 0x2

    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/support/v7/widget/av$g;-><init>()V

    iput v1, p0, Landroid/support/v7/widget/aj;->s:I

    iput v1, p0, Landroid/support/v7/widget/aj;->t:I

    iput-boolean v1, p0, Landroid/support/v7/widget/aj;->v:Z

    iput-boolean v1, p0, Landroid/support/v7/widget/aj;->w:Z

    iput v1, p0, Landroid/support/v7/widget/aj;->x:I

    iput v1, p0, Landroid/support/v7/widget/aj;->y:I

    new-array v0, v2, [I

    iput-object v0, p0, Landroid/support/v7/widget/aj;->z:[I

    new-array v0, v2, [I

    iput-object v0, p0, Landroid/support/v7/widget/aj;->A:[I

    new-array v0, v2, [F

    fill-array-data v0, :array_0

    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    iput v1, p0, Landroid/support/v7/widget/aj;->C:I

    new-instance v0, Landroid/support/v7/widget/aj$1;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/aj$1;-><init>(Landroid/support/v7/widget/aj;)V

    iput-object v0, p0, Landroid/support/v7/widget/aj;->D:Ljava/lang/Runnable;

    new-instance v0, Landroid/support/v7/widget/aj$2;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/aj$2;-><init>(Landroid/support/v7/widget/aj;)V

    iput-object v0, p0, Landroid/support/v7/widget/aj;->E:Landroid/support/v7/widget/av$m;

    iput-object p2, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    iput-object p3, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    iput-object p4, p0, Landroid/support/v7/widget/aj;->o:Landroid/graphics/drawable/StateListDrawable;

    iput-object p5, p0, Landroid/support/v7/widget/aj;->p:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p2}, Landroid/graphics/drawable/StateListDrawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->m:I

    invoke-virtual {p3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->n:I

    invoke-virtual {p4}, Landroid/graphics/drawable/StateListDrawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->q:I

    invoke-virtual {p5}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->r:I

    iput p7, p0, Landroid/support/v7/widget/aj;->i:I

    iput p8, p0, Landroid/support/v7/widget/aj;->j:I

    iget-object v0, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v0, v3}, Landroid/graphics/drawable/StateListDrawable;->setAlpha(I)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v3}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    new-instance v1, Landroid/support/v7/widget/aj$a;

    invoke-direct {v1, p0, v4}, Landroid/support/v7/widget/aj$a;-><init>(Landroid/support/v7/widget/aj;Landroid/support/v7/widget/aj$1;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    new-instance v1, Landroid/support/v7/widget/aj$b;

    invoke-direct {v1, p0, v4}, Landroid/support/v7/widget/aj$b;-><init>(Landroid/support/v7/widget/aj;Landroid/support/v7/widget/aj$1;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/aj;->a(Landroid/support/v7/widget/av;)V

    return-void

    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private a(FF[IIII)I
    .locals 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    aget v1, p3, v1

    aget v2, p3, v0

    sub-int/2addr v1, v2

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    sub-float v2, p2, p1

    int-to-float v1, v1

    div-float v1, v2, v1

    sub-int v2, p4, p6

    int-to-float v3, v2

    mul-float/2addr v1, v3

    float-to-int v1, v1

    add-int v3, p5, v1

    if-ge v3, v2, :cond_0

    if-ltz v3, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method static synthetic a(Landroid/support/v7/widget/aj;I)I
    .locals 0

    iput p1, p0, Landroid/support/v7/widget/aj;->C:I

    return p1
.end method

.method static synthetic a(Landroid/support/v7/widget/aj;)Landroid/animation/ValueAnimator;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method private a(F)V
    .locals 8

    const/4 v7, 0x0

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->g()[I

    move-result-object v3

    aget v0, v3, v7

    int-to-float v0, v0

    const/4 v1, 0x1

    aget v1, v3, v1

    int-to-float v1, v1

    invoke-static {v1, p1}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v2

    iget v0, p0, Landroid/support/v7/widget/aj;->b:I

    int-to-float v0, v0

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v1, p0, Landroid/support/v7/widget/aj;->c:F

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeVerticalScrollRange()I

    move-result v4

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeVerticalScrollOffset()I

    move-result v5

    iget v6, p0, Landroid/support/v7/widget/aj;->t:I

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroid/support/v7/widget/aj;->a(FF[IIII)I

    move-result v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v1, v7, v0}, Landroid/support/v7/widget/av;->scrollBy(II)V

    :cond_1
    iput v2, p0, Landroid/support/v7/widget/aj;->c:F

    goto :goto_0
.end method

.method private a(Landroid/graphics/Canvas;)V
    .locals 8

    const/4 v7, 0x0

    const/high16 v6, 0x3f800000    # 1.0f

    const/4 v5, 0x0

    iget v0, p0, Landroid/support/v7/widget/aj;->s:I

    iget v1, p0, Landroid/support/v7/widget/aj;->m:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroid/support/v7/widget/aj;->b:I

    iget v2, p0, Landroid/support/v7/widget/aj;->a:I

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    iget v3, p0, Landroid/support/v7/widget/aj;->m:I

    iget v4, p0, Landroid/support/v7/widget/aj;->a:I

    invoke-virtual {v2, v5, v5, v3, v4}, Landroid/graphics/drawable/StateListDrawable;->setBounds(IIII)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    iget v3, p0, Landroid/support/v7/widget/aj;->n:I

    iget v4, p0, Landroid/support/v7/widget/aj;->t:I

    invoke-virtual {v2, v5, v5, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->e()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    iget v0, p0, Landroid/support/v7/widget/aj;->m:I

    int-to-float v0, v0

    int-to-float v2, v1

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->translate(FF)V

    const/high16 v0, -0x40800000    # -1.0f

    invoke-virtual {p1, v0, v6}, Landroid/graphics/Canvas;->scale(FF)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1, v6, v6}, Landroid/graphics/Canvas;->scale(FF)V

    iget v0, p0, Landroid/support/v7/widget/aj;->m:I

    neg-int v0, v0

    int-to-float v0, v0

    neg-int v1, v1

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    :goto_0
    return-void

    :cond_0
    int-to-float v2, v0

    invoke-virtual {p1, v2, v7}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    int-to-float v2, v1

    invoke-virtual {p1, v7, v2}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    neg-int v0, v0

    int-to-float v0, v0

    neg-int v1, v1

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_0
.end method

.method private b()V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av$g;)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av$l;)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    iget-object v1, p0, Landroid/support/v7/widget/aj;->E:Landroid/support/v7/widget/av$m;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av$m;)V

    return-void
.end method

.method private b(F)V
    .locals 8

    const/4 v7, 0x0

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->h()[I

    move-result-object v3

    aget v0, v3, v7

    int-to-float v0, v0

    const/4 v1, 0x1

    aget v1, v3, v1

    int-to-float v1, v1

    invoke-static {v1, p1}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v2

    iget v0, p0, Landroid/support/v7/widget/aj;->e:I

    int-to-float v0, v0

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v1, p0, Landroid/support/v7/widget/aj;->f:F

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeHorizontalScrollRange()I

    move-result v4

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeHorizontalScrollOffset()I

    move-result v5

    iget v6, p0, Landroid/support/v7/widget/aj;->s:I

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroid/support/v7/widget/aj;->a(FF[IIII)I

    move-result v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v1, v0, v7}, Landroid/support/v7/widget/av;->scrollBy(II)V

    :cond_1
    iput v2, p0, Landroid/support/v7/widget/aj;->f:F

    goto :goto_0
.end method

.method private b(I)V
    .locals 3

    const/4 v2, 0x2

    if-ne p1, v2, :cond_0

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    sget-object v1, Landroid/support/v7/widget/aj;->g:[I

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->f()V

    :cond_0
    if-nez p1, :cond_2

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->d()V

    :goto_0
    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-ne v0, v2, :cond_3

    if-eq p1, v2, :cond_3

    iget-object v0, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    sget-object v1, Landroid/support/v7/widget/aj;->h:[I

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    const/16 v0, 0x4b0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/aj;->c(I)V

    :cond_1
    :goto_1
    iput p1, p0, Landroid/support/v7/widget/aj;->x:I

    return-void

    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/widget/aj;->a()V

    goto :goto_0

    :cond_3
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    const/16 v0, 0x5dc

    invoke-direct {p0, v0}, Landroid/support/v7/widget/aj;->c(I)V

    goto :goto_1
.end method

.method private b(Landroid/graphics/Canvas;)V
    .locals 7

    const/4 v6, 0x0

    const/4 v5, 0x0

    iget v0, p0, Landroid/support/v7/widget/aj;->t:I

    iget v1, p0, Landroid/support/v7/widget/aj;->q:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroid/support/v7/widget/aj;->e:I

    iget v2, p0, Landroid/support/v7/widget/aj;->d:I

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/support/v7/widget/aj;->o:Landroid/graphics/drawable/StateListDrawable;

    iget v3, p0, Landroid/support/v7/widget/aj;->d:I

    iget v4, p0, Landroid/support/v7/widget/aj;->q:I

    invoke-virtual {v2, v5, v5, v3, v4}, Landroid/graphics/drawable/StateListDrawable;->setBounds(IIII)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->p:Landroid/graphics/drawable/Drawable;

    iget v3, p0, Landroid/support/v7/widget/aj;->s:I

    iget v4, p0, Landroid/support/v7/widget/aj;->r:I

    invoke-virtual {v2, v5, v5, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    int-to-float v2, v0

    invoke-virtual {p1, v6, v2}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->p:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    int-to-float v2, v1

    invoke-virtual {p1, v2, v6}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v2, p0, Landroid/support/v7/widget/aj;->o:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    neg-int v1, v1

    int-to-float v1, v1

    neg-int v0, v0

    int-to-float v0, v0

    invoke-virtual {p1, v1, v0}, Landroid/graphics/Canvas;->translate(FF)V

    return-void
.end method

.method static synthetic b(Landroid/support/v7/widget/aj;)V
    .locals 0

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->d()V

    return-void
.end method

.method static synthetic b(Landroid/support/v7/widget/aj;I)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/support/v7/widget/aj;->b(I)V

    return-void
.end method

.method static synthetic c(Landroid/support/v7/widget/aj;)Landroid/graphics/drawable/StateListDrawable;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->k:Landroid/graphics/drawable/StateListDrawable;

    return-object v0
.end method

.method private c()V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/av;->b(Landroid/support/v7/widget/av$g;)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/av;->b(Landroid/support/v7/widget/av$l;)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    iget-object v1, p0, Landroid/support/v7/widget/aj;->E:Landroid/support/v7/widget/av$m;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av;->b(Landroid/support/v7/widget/av$m;)V

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->f()V

    return-void
.end method

.method private c(I)V
    .locals 4

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->f()V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    iget-object v1, p0, Landroid/support/v7/widget/aj;->D:Ljava/lang/Runnable;

    int-to-long v2, p1

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v7/widget/av;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method static synthetic d(Landroid/support/v7/widget/aj;)Landroid/graphics/drawable/Drawable;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->l:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method private d()V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->invalidate()V

    return-void
.end method

.method private e()Z
    .locals 2

    const/4 v0, 0x1

    iget-object v1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-static {v1}, Landroid/support/v4/i/q;->e(Landroid/view/View;)I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private f()V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    iget-object v1, p0, Landroid/support/v7/widget/aj;->D:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av;->removeCallbacks(Ljava/lang/Runnable;)Z

    return-void
.end method

.method private g()[I
    .locals 4

    iget-object v0, p0, Landroid/support/v7/widget/aj;->z:[I

    const/4 v1, 0x0

    iget v2, p0, Landroid/support/v7/widget/aj;->j:I

    aput v2, v0, v1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->z:[I

    const/4 v1, 0x1

    iget v2, p0, Landroid/support/v7/widget/aj;->t:I

    iget v3, p0, Landroid/support/v7/widget/aj;->j:I

    sub-int/2addr v2, v3

    aput v2, v0, v1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->z:[I

    return-object v0
.end method

.method private h()[I
    .locals 4

    iget-object v0, p0, Landroid/support/v7/widget/aj;->A:[I

    const/4 v1, 0x0

    iget v2, p0, Landroid/support/v7/widget/aj;->j:I

    aput v2, v0, v1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->A:[I

    const/4 v1, 0x1

    iget v2, p0, Landroid/support/v7/widget/aj;->s:I

    iget v3, p0, Landroid/support/v7/widget/aj;->j:I

    sub-int/2addr v2, v3

    aput v2, v0, v1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->A:[I

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 5

    const/4 v4, 0x1

    iget v0, p0, Landroid/support/v7/widget/aj;->C:I

    packed-switch v0, :pswitch_data_0

    :goto_0
    :pswitch_0
    return-void

    :pswitch_1
    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :pswitch_2
    iput v4, p0, Landroid/support/v7/widget/aj;->C:I

    iget-object v1, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    const/4 v0, 0x2

    new-array v2, v0, [F

    const/4 v3, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    aput v0, v2, v3

    const/high16 v0, 0x3f800000    # 1.0f

    aput v0, v2, v4

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method a(I)V
    .locals 4

    iget v0, p0, Landroid/support/v7/widget/aj;->C:I

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :pswitch_1
    const/4 v0, 0x3

    iput v0, p0, Landroid/support/v7/widget/aj;->C:I

    iget-object v1, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    const/4 v0, 0x2

    new-array v2, v0, [F

    const/4 v3, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    aput v0, v2, v3

    const/4 v0, 0x1

    const/4 v3, 0x0

    aput v3, v2, v0

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    int-to-long v2, p1

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object v0, p0, Landroid/support/v7/widget/aj;->B:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method a(II)V
    .locals 9

    const/high16 v8, 0x40000000    # 2.0f

    const/4 v2, 0x0

    const/4 v1, 0x1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeVerticalScrollRange()I

    move-result v3

    iget v4, p0, Landroid/support/v7/widget/aj;->t:I

    sub-int v0, v3, v4

    if-lez v0, :cond_1

    iget v0, p0, Landroid/support/v7/widget/aj;->t:I

    iget v5, p0, Landroid/support/v7/widget/aj;->i:I

    if-lt v0, v5, :cond_1

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Landroid/support/v7/widget/aj;->v:Z

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->computeHorizontalScrollRange()I

    move-result v5

    iget v6, p0, Landroid/support/v7/widget/aj;->s:I

    sub-int v0, v5, v6

    if-lez v0, :cond_2

    iget v0, p0, Landroid/support/v7/widget/aj;->s:I

    iget v7, p0, Landroid/support/v7/widget/aj;->i:I

    if-lt v0, v7, :cond_2

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Landroid/support/v7/widget/aj;->w:Z

    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->v:Z

    if-nez v0, :cond_3

    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->w:Z

    if-nez v0, :cond_3

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-eqz v0, :cond_0

    invoke-direct {p0, v2}, Landroid/support/v7/widget/aj;->b(I)V

    :cond_0
    :goto_2
    return-void

    :cond_1
    move v0, v2

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_1

    :cond_3
    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->v:Z

    if-eqz v0, :cond_4

    int-to-float v0, p2

    int-to-float v2, v4

    div-float/2addr v2, v8

    add-float/2addr v0, v2

    int-to-float v2, v4

    mul-float/2addr v0, v2

    int-to-float v2, v3

    div-float/2addr v0, v2

    float-to-int v0, v0

    iput v0, p0, Landroid/support/v7/widget/aj;->b:I

    mul-int v0, v4, v4

    div-int/2addr v0, v3

    invoke-static {v4, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->a:I

    :cond_4
    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->w:Z

    if-eqz v0, :cond_5

    int-to-float v0, p1

    int-to-float v2, v6

    div-float/2addr v2, v8

    add-float/2addr v0, v2

    int-to-float v2, v6

    mul-float/2addr v0, v2

    int-to-float v2, v5

    div-float/2addr v0, v2

    float-to-int v0, v0

    iput v0, p0, Landroid/support/v7/widget/aj;->e:I

    mul-int v0, v6, v6

    div-int/2addr v0, v5

    invoke-static {v6, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->d:I

    :cond_5
    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-eqz v0, :cond_6

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-ne v0, v1, :cond_0

    :cond_6
    invoke-direct {p0, v1}, Landroid/support/v7/widget/aj;->b(I)V

    goto :goto_2
.end method

.method public a(Landroid/graphics/Canvas;Landroid/support/v7/widget/av;Landroid/support/v7/widget/av$t;)V
    .locals 2

    iget v0, p0, Landroid/support/v7/widget/aj;->s:I

    iget-object v1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v1}, Landroid/support/v7/widget/av;->getWidth()I

    move-result v1

    if-ne v0, v1, :cond_0

    iget v0, p0, Landroid/support/v7/widget/aj;->t:I

    iget-object v1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v1}, Landroid/support/v7/widget/av;->getHeight()I

    move-result v1

    if-eq v0, v1, :cond_2

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getWidth()I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->s:I

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getHeight()I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/aj;->t:I

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/aj;->b(I)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget v0, p0, Landroid/support/v7/widget/aj;->C:I

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->v:Z

    if-eqz v0, :cond_3

    invoke-direct {p0, p1}, Landroid/support/v7/widget/aj;->a(Landroid/graphics/Canvas;)V

    :cond_3
    iget-boolean v0, p0, Landroid/support/v7/widget/aj;->w:Z

    if-eqz v0, :cond_1

    invoke-direct {p0, p1}, Landroid/support/v7/widget/aj;->b(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/av;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    if-ne v0, p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    if-eqz v0, :cond_2

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->c()V

    :cond_2
    iput-object p1, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    iget-object v0, p0, Landroid/support/v7/widget/aj;->u:Landroid/support/v7/widget/av;

    if-eqz v0, :cond_0

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->b()V

    goto :goto_0
.end method

.method public a(Z)V
    .locals 0

    return-void
.end method

.method a(FF)Z
    .locals 2

    invoke-direct {p0}, Landroid/support/v7/widget/aj;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p0, Landroid/support/v7/widget/aj;->m:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_2

    :cond_0
    iget v0, p0, Landroid/support/v7/widget/aj;->b:I

    iget v1, p0, Landroid/support/v7/widget/aj;->a:I

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float v0, p2, v0

    if-ltz v0, :cond_2

    iget v0, p0, Landroid/support/v7/widget/aj;->b:I

    iget v1, p0, Landroid/support/v7/widget/aj;->a:I

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    int-to-float v0, v0

    cmpg-float v0, p2, v0

    if-gtz v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    iget v0, p0, Landroid/support/v7/widget/aj;->s:I

    iget v1, p0, Landroid/support/v7/widget/aj;->m:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float v0, p1, v0

    if-gez v0, :cond_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/av;Landroid/view/MotionEvent;)Z
    .locals 6

    const/4 v1, 0x0

    const/4 v5, 0x2

    const/4 v0, 0x1

    iget v2, p0, Landroid/support/v7/widget/aj;->x:I

    if-ne v2, v0, :cond_5

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {p0, v2, v3}, Landroid/support/v7/widget/aj;->a(FF)Z

    move-result v2

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {p0, v3, v4}, Landroid/support/v7/widget/aj;->b(FF)Z

    move-result v3

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-nez v4, :cond_4

    if-nez v2, :cond_0

    if-eqz v3, :cond_4

    :cond_0
    if-eqz v3, :cond_3

    iput v0, p0, Landroid/support/v7/widget/aj;->y:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Landroid/support/v7/widget/aj;->f:F

    :cond_1
    :goto_0
    invoke-direct {p0, v5}, Landroid/support/v7/widget/aj;->b(I)V

    :cond_2
    :goto_1
    return v0

    :cond_3
    if-eqz v2, :cond_1

    iput v5, p0, Landroid/support/v7/widget/aj;->y:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Landroid/support/v7/widget/aj;->c:F

    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_1

    :cond_5
    iget v2, p0, Landroid/support/v7/widget/aj;->x:I

    if-eq v2, v5, :cond_2

    move v0, v1

    goto :goto_1
.end method

.method public b(Landroid/support/v7/widget/av;Landroid/view/MotionEvent;)V
    .locals 5

    const/4 v1, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x2

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroid/support/v7/widget/aj;->a(FF)Z

    move-result v0

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/widget/aj;->b(FF)Z

    move-result v1

    if-nez v0, :cond_2

    if-eqz v1, :cond_0

    :cond_2
    if-eqz v1, :cond_4

    iput v4, p0, Landroid/support/v7/widget/aj;->y:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    float-to-int v0, v0

    int-to-float v0, v0

    iput v0, p0, Landroid/support/v7/widget/aj;->f:F

    :cond_3
    :goto_1
    invoke-direct {p0, v3}, Landroid/support/v7/widget/aj;->b(I)V

    goto :goto_0

    :cond_4
    if-eqz v0, :cond_3

    iput v3, p0, Landroid/support/v7/widget/aj;->y:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    float-to-int v0, v0

    int-to-float v0, v0

    iput v0, p0, Landroid/support/v7/widget/aj;->c:F

    goto :goto_1

    :cond_5
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v4, :cond_6

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-ne v0, v3, :cond_6

    iput v1, p0, Landroid/support/v7/widget/aj;->c:F

    iput v1, p0, Landroid/support/v7/widget/aj;->f:F

    invoke-direct {p0, v4}, Landroid/support/v7/widget/aj;->b(I)V

    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/widget/aj;->y:I

    goto :goto_0

    :cond_6
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v3, :cond_0

    iget v0, p0, Landroid/support/v7/widget/aj;->x:I

    if-ne v0, v3, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/widget/aj;->a()V

    iget v0, p0, Landroid/support/v7/widget/aj;->y:I

    if-ne v0, v4, :cond_7

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/aj;->b(F)V

    :cond_7
    iget v0, p0, Landroid/support/v7/widget/aj;->y:I

    if-ne v0, v3, :cond_0

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/aj;->a(F)V

    goto :goto_0
.end method

.method b(FF)Z
    .locals 2

    iget v0, p0, Landroid/support/v7/widget/aj;->t:I

    iget v1, p0, Landroid/support/v7/widget/aj;->q:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float v0, p2, v0

    if-ltz v0, :cond_0

    iget v0, p0, Landroid/support/v7/widget/aj;->e:I

    iget v1, p0, Landroid/support/v7/widget/aj;->d:I

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float v0, p1, v0

    if-ltz v0, :cond_0

    iget v0, p0, Landroid/support/v7/widget/aj;->e:I

    iget v1, p0, Landroid/support/v7/widget/aj;->d:I

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    int-to-float v0, v0

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
