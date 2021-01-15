// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelzombie extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public Modelzombie() {
		textureWidth = 192;
		textureHeight = 96;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(48, 48).addBox(-12.0F, -48.0F, -6.0F, 24.0F, 36.0F, 12.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -48.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-12.0F, -24.0F, -12.0F, 24.0F, 24.0F, 24.0F, 0.0F, false);
		head.setTextureOffset(96, 0).addBox(-12.0F, -24.0F, -12.0F, 24.0F, 24.0F, 24.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, -46.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(120, 48).addBox(-19.0F, -2.0F, -6.0F, 12.0F, 36.0F, 12.0F, 0.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setRotationPoint(-1.0F, 55.0F, 1.0F);
		rightArm.addChild(rightItem);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, -46.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(120, 48).addBox(7.0F, -2.0F, -6.0F, 12.0F, 36.0F, 12.0F, 0.0F, true);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 48).addBox(-10.1F, 0.0F, -6.0F, 12.0F, 36.0F, 12.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 48).addBox(-1.9F, 0.0F, -6.0F, 12.0F, 36.0F, 12.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}